package es.unex.giiis.golaso.api.partidos;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import es.unex.giiis.golaso.AppExecutors;
import es.unex.giiis.golaso.model.Partido;

public class PartidosLoaderRunnable implements Runnable {

    private final InputStream mInFile;
    private final OnPartidosLoadedListener mOnPartidosLoadedListener;


    public PartidosLoaderRunnable(InputStream inFile, OnPartidosLoadedListener onPartidosLoadedListener){

        mInFile = inFile;
        mOnPartidosLoadedListener = onPartidosLoadedListener;

    }

    @Override
    public void run(){

        // Obtención de los datos a partir del InputStream

        // Parse json file into JsonReader
        JsonReader reader = new JsonReader(new InputStreamReader(mInFile));
        // Parse JsonReader into list of Repo using Gson
        List<Partido> partidos = Arrays.asList(new Gson().fromJson(reader, Partido[].class));

        // Llamada al Listener con los datos obtenidos
        AppExecutors.getInstance().mainThread().execute(new Runnable() {
            @Override
            public void run() {

                mOnPartidosLoadedListener.onPartidosLoaded(partidos);

            }
        });

    }
}
