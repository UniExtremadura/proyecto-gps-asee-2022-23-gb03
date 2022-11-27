package es.unex.giiis.golaso.api;

import java.util.List;

import es.unex.giiis.golaso.model.Equipo;
import es.unex.giiis.golaso.model.Jugador;
import es.unex.giiis.golaso.model.Partido;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FirebaseService {

    @GET("Equipos.json")
    Call<List<Equipo>> callEquipos();

    @GET("Jugadores.json")
    Call<List<Jugador>> callJugadores();

    @GET("Partidos.json")
    Call<List<Partido>> callPartidos();

}
