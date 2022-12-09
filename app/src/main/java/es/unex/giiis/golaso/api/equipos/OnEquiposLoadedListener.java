package es.unex.giiis.golaso.api.equipos;

import java.util.List;

import es.unex.giiis.golaso.model.Equipo;

public interface OnEquiposLoadedListener {

    void onEquiposLoaded(List<Equipo> equipos);

}
