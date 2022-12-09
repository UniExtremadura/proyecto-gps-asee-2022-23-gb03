package es.unex.giiis.golaso.api.jugadores;

import java.util.List;

import es.unex.giiis.golaso.model.Jugador;

public interface OnJugadoresLoadedListener {

    void onJugadoresLoaded(List<Jugador> jugadores);

}
