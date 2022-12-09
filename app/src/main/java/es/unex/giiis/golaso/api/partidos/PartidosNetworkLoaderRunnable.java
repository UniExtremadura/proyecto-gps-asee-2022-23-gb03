package es.unex.giiis.golaso.api.partidos;

import java.io.IOException;
import java.util.List;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.api.FirebaseService;
import es.unex.giiis.golaso.model.Partido;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PartidosNetworkLoaderRunnable implements Runnable {

    private final OnPartidosLoadedListener mOnPartidosLoadedListener;

    public PartidosNetworkLoaderRunnable(OnPartidosLoadedListener mOnPartidosLoadedListener) {

        this.mOnPartidosLoadedListener = mOnPartidosLoadedListener;

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
            List<Partido> partidos = service.callPartidos().execute().body();
            AppExecutors.getInstance().mainThread().execute(() ->
                    // Llamada al Listener con los datos obtenidos
                    mOnPartidosLoadedListener.onPartidosLoaded(partidos));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
