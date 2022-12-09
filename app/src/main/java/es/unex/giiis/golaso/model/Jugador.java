package es.unex.giiis.golaso.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Jugador {

    @SerializedName("asistencias")
    @Expose
    private long asistencias;

    @SerializedName("edad")
    @Expose
    private long edad;

    @SerializedName("equipo")
    @Expose
    private String equipo;

    @SerializedName("fecha_nac")
    @Expose
    private long añoNac;

    @SerializedName("goles")
    @Expose
    private long goles;

    @SerializedName("id_equipo")
    @Expose
    private long idEquipo;

    @SerializedName("id_jugador")
    @Expose
    private long idJugador;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("pais")
    @Expose
    private String pais;

    @SerializedName("pj")
    @Expose
    private long partidosJugados;

    @SerializedName("posicion")
    @Expose
    private String posicion;

    @SerializedName("foto")
    @Expose
    private String foto;

    public Jugador(long mId, String mNombre, String mEquipo, String mPosicion, long mGoles,
                   long mAsistencias, long mEdad, long mFechaNacimiento, long mPartidos,
                   String mPais, String mFoto) {

        this.idJugador = mId;
        this.nombre = mNombre;
        this.equipo = mEquipo;
        this.posicion = mPosicion;
        this.goles = mGoles;
        this.asistencias = mAsistencias;
        this.edad = mEdad;
        this.añoNac = mFechaNacimiento;
        this.partidosJugados = mPartidos;
        this.pais = mPais;
        this.foto = mFoto;

    }

    public long getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(long asistencias) {
        this.asistencias = asistencias;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public String getEquipo() {

        return equipo;

    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public long getAñoNac() {
        return añoNac;
    }

    public void setAñoNac(long añoNac) {
        this.añoNac = añoNac;
    }

    public long getGoles() {
        return goles;
    }

    public void setGoles(long goles) {
        this.goles = goles;
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(long idJugador) {
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

    public long getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(long partidosJugados) {

        this.partidosJugados = partidosJugados;

    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getFoto() {

        return foto;

    }

    public void setFoto(String foto) {

        this.foto = foto;

    }

}
