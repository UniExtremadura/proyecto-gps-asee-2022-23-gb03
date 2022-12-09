package es.unex.giiis.golaso.api.equipos;

import java.io.IOException;
import java.util.List;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.api.FirebaseService;
import es.unex.giiis.golaso.model.Equipo;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EquiposNetworkLoaderRunnable implements Runnable{

    private final OnEquiposLoadedListener mOnEquiposLoadedListener;

    public EquiposNetworkLoaderRunnable(OnEquiposLoadedListener mOnEquiposLoadedListener) {

        this.mOnEquiposLoadedListener = mOnEquiposLoadedListener;

    }

    @Override
    public void run(){

        // Instanciación de Retrofit y llamada síncrona

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://golaso-39dd8-default-rtdb.europe-west1.firebasedatabase.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FirebaseService service = retrofit.create(FirebaseService.class);

        try {

            List<Equipo> equipos = service.callEquipos().execute().body();
            AppExecutors.getInstance().mainThread().execute(() ->
                    // Llamada al Listener con los datos obtenidos
                    mOnEquiposLoadedListener.onEquiposLoaded(equipos));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
