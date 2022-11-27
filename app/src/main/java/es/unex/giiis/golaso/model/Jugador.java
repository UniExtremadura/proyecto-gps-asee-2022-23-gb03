package es.unex.giiis.golaso.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Jugador {

    @SerializedName("asistencias")
    @Expose
    private Integer asistencias;

    @SerializedName("edad")
    @Expose
    private Integer edad;

    @SerializedName("equipo")
    @Expose
    private String equipo;

    @SerializedName("fecha_nac")
    @Expose
    private Integer añoNac;

    @SerializedName("goles")
    @Expose
    private Integer goles;

    @SerializedName("id_equipo")
    @Expose
    private Integer idEquipo;

    @SerializedName("id_jugador")
    @Expose
    private Integer idJugador;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("pais")
    @Expose
    private String pais;

    @SerializedName("pj")
    @Expose
    private Integer partidosJugados;

    @SerializedName("posicion")
    @Expose
    private String posicion;

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEquipo() {

        return equipo;

    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Integer getAñoNac() {
        return añoNac;
    }

    public void setAñoNac(Integer añoNac) {
        this.añoNac = añoNac;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(Integer partidosJugados) {

        this.partidosJugados = partidosJugados;

    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

}
