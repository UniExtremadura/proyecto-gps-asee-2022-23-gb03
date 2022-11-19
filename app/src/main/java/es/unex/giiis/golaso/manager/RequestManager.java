package es.unex.giiis.golaso.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import es.unex.giiis.golaso.ResponseListener;
import es.unex.giiis.golaso.model.Equipo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RequestManager {
    Context context;



    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://golaso-39dd8-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getEquipos(ResponseListener listener) {
        CallEquipos callEquipos = retrofit.create(CallEquipos.class);
        Call<List<Equipo>> call = callEquipos.callEquipos();
        call.enqueue(new Callback<List<Equipo>>() {
            @Override
            public void onResponse(Call<List<Equipo>> call, Response<List<Equipo>> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }

                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<List<Equipo>> call, Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    private interface CallEquipos {

        @GET("Equipos.json")
        Call<List<Equipo>> callEquipos();
    }
}
