package es.unex.giiis.golaso;

import java.util.List;

import es.unex.giiis.golaso.model.Equipo;

public interface ResponseListener {
    void didFetch(List<Equipo> list, String message);
    void didError(String message);
}
