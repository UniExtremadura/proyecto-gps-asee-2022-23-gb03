package es.unex.giiis.golaso.api.goleadores;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.model.Jugador;

public class GoleadoresLoaderRunnable implements Runnable{

    private final InputStream mInFile;
    private final OnJugadoresLoadedListener mOnJugadoresLoadedListener;


    public GoleadoresLoaderRunnable(InputStream inFile, OnJugadoresLoadedListener onJugadoresLoadedListener){

        mInFile = inFile;
        mOnJugadoresLoadedListener = onJugadoresLoadedListener;

    }

    @Override
    public void run(){

        // Obtención de los datos a partir del InputStream

        // Parse json file into JsonReader
        JsonReader reader = new JsonReader(new InputStreamReader(mInFile));
        // Parse JsonReader into list of Repo using Gson
        List<Jugador> jugadores = Arrays.asList(new Gson().fromJson(reader, Jugador[].class));

        // Llamada al Listener con los datos obtenidos
        AppExecutors.getInstance().mainThread().execute(new Runnable() {
            @Override
            public void run() {

                mOnJugadoresLoadedListener.onJugadoresLoaded(jugadores);

            }
        });

    }

}

