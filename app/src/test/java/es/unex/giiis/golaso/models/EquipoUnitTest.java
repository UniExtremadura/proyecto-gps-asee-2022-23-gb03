package es.unex.giiis.golaso.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.unex.giiis.golaso.model.Equipo;

public class EquipoUnitTest {

    @Test
    public void shouldGetId(){

        Equipo e = new Equipo(42, "Equipo", "Entrenador", "Estadio",
                "Ubicación",  "Logo", "PosiciónAcceso", 0,
                0, 0, 0, 0, 0,
                0, 0);

        assertEquals(42, e.getIdEquipo());

    }

    @Test
    public void shouldSetId(){

        Equipo e = new Equipo(42, "Equipo", "Entrenador", "Estadio",
                "Ubicación",  "Logo", "PosiciónAcceso", 0,
                0, 0, 0, 0, 0,
                0, 0);

        e.setIdEquipo(21);
        assertEquals(21, e.getIdEquipo());

    }

    @Test
    public void shouldGetNombre(){

        Equipo e = new Equipo(0, "Betis", "Entrenador", "Estadio",
                "Ubicación",  "Logo", "PosiciónAcceso", 0,
                0, 0, 0, 0, 0,
                0, 0);

        assertEquals("Betis", e.getNombre());

    }

    @Test
    public void shouldSetNombre(){

        Equipo e = new Equipo(0, "Betis", "Entrenador", "Estadio",
                "Ubicación",  "Logo", "PosiciónAcceso", 0,
                0, 0, 0, 0, 0,
                0, 0);

        e.setNombre("Sevilla");
        assertEquals("Sevilla", e.getNombre());

    }

    @Test
    public void shouldGetEntrenador(){

        Equipo e = new Equipo(0, "Equipo", "Luis Enrique", "Estadio",
                "Ubicación",  "Logo", "PosiciónAcceso", 0,
                0, 0, 0, 0, 0,
                0, 0);

        assertEquals("Luis Enrique", e.getEntrenador());

    }

    @Test
    public void shouldSetEntrenador(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador", "Estadio",
                "Ubicación",  "Logo", "PosiciónAcceso", 0,
                0, 0, 0, 0, 0,
                0, 0);

        e.setEntrenador("Vicente del Bosque");
        assertEquals("Vicente del Bosque", e.getEntrenador());

    }

    @Test
    public void shouldGetEstadio(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Benito Villamarín", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 0, 0);

        assertEquals("Benito Villamarín", e.getEstadio());

    }

    @Test
    public void shouldSetEstadio(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Benito Villamarín", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 0, 0);

        e.setEstadio("Santiago Bernabéu");
        assertEquals("Santiago Bernabéu", e.getEstadio());

    }

    @Test
    public void shouldGetUbicacion(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Talayuela",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 0, 0);

        assertEquals("Talayuela", e.getUbicacion());

    }

    @Test
    public void shouldSetUbicacion(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Talayuela",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 0, 0);

        e.setUbicacion("Badajoz");
        assertEquals("Badajoz", e.getUbicacion());

    }

    @Test
    public void shouldGetLogo(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "https://acortar.link/jaf6No",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 0, 0);

        assertEquals("https://acortar.link/jaf6No", e.getLogo());

    }

    @Test
    public void shouldSetLogo(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "https://acortar.link/jaf6No",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 0, 0);

        e.setLogo("https://acortar.link/jdmV9f");
        assertEquals("https://acortar.link/jdmV9f", e.getLogo());

    }

    @Test
    public void shouldGetPosicionAcceso(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "Primera", 0, 0, 0,
                0, 0, 0, 0, 0);

        assertEquals("Primera", e.getPosicionAcesso());

    }

    @Test
    public void shouldSetPosicionAcceso(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "Primera", 0, 0, 0,
                0, 0, 0, 0, 0);

        e.setPosicionAcesso("Segunda");
        assertEquals("Segunda", e.getPosicionAcesso());

    }

    @Test
    public void shouldGetPosicion(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 3, 0, 0,
                0, 0, 0, 0, 0);

        assertEquals(3, e.getPosicion());

    }

    @Test
    public void shouldSetPosicion(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 3, 0, 0,
                0, 0, 0, 0, 0);

        e.setPosicion(5);
        assertEquals(5, e.getPosicion());

    }

    @Test
    public void shouldGetGolesFavor(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 10, 0,
                0, 0, 0, 0, 0);

        assertEquals(10, e.getGf());

    }

    @Test
    public void shouldSetGolesFavor(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 10, 0,
                0, 0, 0, 0, 0);

        e.setGf(15);
        assertEquals(15, e.getGf());

    }

    @Test
    public void shouldGetGolesContra(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 5,
                0, 0, 0, 0, 0);

        assertEquals(5, e.getGc());

    }

    @Test
    public void shouldSetGolesContra(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 5,
                0, 0, 0, 0, 0);

        e.setGc(10);
        assertEquals(10, e.getGc());

    }

    @Test
    public void shouldGetPartidosJugados(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                20, 0, 0, 0, 0);

        assertEquals(20, e.getPj());

    }

    @Test
    public void shouldSetPartidosJugados(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                20, 0, 0, 0, 0);

        e.setPj(25);
        assertEquals(25, e.getPj());

    }

    @Test
    public void shouldGetPartidosGanados(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 40, 0, 0, 0);

        assertEquals(40, e.getPg());

    }

    @Test
    public void shouldSetPartidosGanados(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 40, 0, 0, 0);

        e.setPg(45);
        assertEquals(45, e.getPg());

    }

    @Test
    public void shouldGetPartidosEmpatados(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 2, 0, 0);

        assertEquals(2, e.getPe());

    }

    @Test
    public void shouldSetPartidosEmpatados(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 2, 0, 0);

        e.setPe(6);
        assertEquals(6, e.getPe());

    }

    @Test
    public void shouldGetPartidosPerdidos(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 1, 0);

        assertEquals(1, e.getPp());

    }

    @Test
    public void shouldSetPartidosPerdidos(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 1, 0);

        e.setPp(3);
        assertEquals(3, e.getPp());

    }

    @Test
    public void shouldGetPuntos(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 0, 27);

        assertEquals(27, e.getPt());

    }

    @Test
    public void shouldSetPuntos(){

        Equipo e = new Equipo(0, "Equipo", "Entrenador",
                "Estadio", "Ubicación",  "Logo",
                "PosiciónAcceso", 0, 0, 0,
                0, 0, 0, 0, 27);

        e.setPt(30);
        assertEquals(30, e.getPt());

    }

}
