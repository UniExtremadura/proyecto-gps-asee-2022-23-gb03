package es.unex.giiis.golaso.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.unex.giiis.golaso.model.Jugador;

public class JugadorUnitTest {

    @Test
    public void shouldGetId(){

        Jugador j = new Jugador(42, "Jugador", "Equipo", "Posición",
                0, 0, 0, 0, 0, "Pais",
                "Foto");

        assertEquals(42, j.getIdJugador());

    }

    @Test
    public void shouldSetId(){

        Jugador j = new Jugador(42, "Jugador", "Equipo", "Posición",
                0, 0, 0, 0, 0, "Pais",
                "Foto");

        j.setIdJugador(21);
        assertEquals(21, j.getIdJugador());

    }

    @Test
    public void shouldGetNombre(){

        Jugador j = new Jugador(0, "Lionel Messi", "Equipo", "Posición",
                0, 0, 0, 0, 0, "Pais",
                "Foto");

        assertEquals("Lionel Messi", j.getNombre());

    }

    @Test
    public void shouldSetNombre(){

        Jugador j = new Jugador(0, "Lionel Messi", "Equipo", "Posición",
                0, 0, 0, 0, 0, "Pais",
                "Foto");

        j.setNombre("Cristiano Ronaldo");
        assertEquals("Cristiano Ronaldo", j.getNombre());

    }

    @Test
    public void shouldGetEquipo(){

        Jugador j = new Jugador(0, "Jugador", "Barcelona", "Posición",
                0, 0, 0, 0, 0, "Pais",
                "Foto");

        assertEquals("Barcelona", j.getEquipo());

    }

    @Test
    public void shouldSetEquipo(){

        Jugador j = new Jugador(0, "Jugador", "Barcelona", "Posición",
                0, 0, 0, 0, 0, "Pais",
                "Foto");

        j.setEquipo("Real Madrid");
        assertEquals("Real Madrid", j.getEquipo());

    }

    @Test
    public void shouldGetPosicion(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Delantero",
                0, 0, 0, 0, 0, "Pais",
                "Foto");

        assertEquals("Delantero", j.getPosicion());

    }

    @Test
    public void shouldSetPosicion(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Delantero",
                0, 0, 0, 0, 0, "Pais",
                "Foto");

        j.setPosicion("Defensa");
        assertEquals("Defensa", j.getPosicion());

    }

    @Test
    public void shouldGetGoles(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                10, 0, 0, 0, 0, "Pais",
                "Foto");

        assertEquals(10, j.getGoles());

    }

    @Test
    public void shouldSetGoles(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                10, 0, 0, 0, 0, "Pais",
                "Foto");

        j.setGoles(20);
        assertEquals(20, j.getGoles());

    }

    @Test
    public void shouldGetAsistencias(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 15, 0, 0, 0, "Pais",
                "Foto");

        assertEquals(15, j.getAsistencias());

    }

    @Test
    public void shouldSetAsistencias(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 15, 0, 0, 0, "Pais",
                "Foto");

        j.setAsistencias(25);
        assertEquals(25, j.getAsistencias());

    }

    @Test
    public void shouldGetEdad(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 0, 41, 0, 0, "Pais",
                "Foto");

        assertEquals(41, j.getEdad());

    }

    @Test
    public void shouldSetEdad(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 0, 41, 0, 0, "Pais",
                "Foto");

        j.setEdad(31);
        assertEquals(31, j.getEdad());

    }

    @Test
    public void shouldGetFechaNacimiento(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 0, 0, 1999, 0, "Pais",
                "Foto");

        assertEquals(1999, j.getAñoNac());

    }

    @Test
    public void shouldSetFechaNacimiento(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 0, 0, 1999, 0, "Pais",
                "Foto");

        j.setAñoNac(1979);
        assertEquals(1979, j.getAñoNac());

    }

    @Test
    public void shouldGetPais(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 0, 0, 0, 0, "España",
                "Foto");

        assertEquals("España", j.getPais());

    }

    @Test
    public void shouldSetPais(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 0, 0, 0, 0, "España",
                "Foto");

        j.setPais("Argentina");
        assertEquals("Argentina", j.getPais());

    }

    @Test
    public void shouldGetFoto(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 0, 0, 0, 0, "Pais",
                "https://acortar.link/zrqh59");

        assertEquals("https://acortar.link/zrqh59", j.getFoto());

    }

    @Test
    public void shouldSetFoto(){

        Jugador j = new Jugador(0, "Jugador", "Equipo", "Posición",
                0, 0, 0, 0, 0, "Pais",
                "https://acortar.link/zrqh59");

        j.setFoto("https://acortar.link/ZbvkUe");
        assertEquals("https://acortar.link/ZbvkUe", j.getFoto());

    }

}
