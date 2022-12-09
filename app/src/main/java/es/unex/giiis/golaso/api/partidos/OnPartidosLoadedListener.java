package es.unex.giiis.golaso.api.partidos;

import java.util.List;

import es.unex.giiis.golaso.model.Partido;

public interface OnPartidosLoadedListener {

    void onPartidosLoaded(List<Partido> equipos);

}