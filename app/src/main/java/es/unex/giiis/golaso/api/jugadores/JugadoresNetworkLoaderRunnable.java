package es.unex.giiis.golaso.api.jugadores;

import java.io.IOException;
import java.util.List;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.api.FirebaseService;
import es.unex.giiis.golaso.model.Jugador;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JugadoresNetworkLoaderRunnable implements Runnable{

    private final OnJugadoresLoadedListener mOnJugadoresLoadedListener;

    public JugadoresNetworkLoaderRunnable(OnJugadoresLoadedListener mOnJugadoresLoadedListener) {

        this.mOnJugadoresLoadedListener = mOnJugadoresLoadedListener;

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

            List<Jugador> jugadores = service.callJugadores().execute().body();
            AppExecutors.getInstance().mainThread().execute(() ->
                    // Llamada al Listener con los datos obtenidos
                    mOnJugadoresLoadedListener.onJugadoresLoaded(jugadores));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
