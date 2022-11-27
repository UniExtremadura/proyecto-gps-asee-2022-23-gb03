package es.unex.giiis.golaso.api.goleadores;

import java.util.List;

import es.unex.giiis.golaso.model.Jugador;

public interface OnJugadoresLoadedListener {

    void onJugadoresLoaded(List<Jugador> goleadores);

}


