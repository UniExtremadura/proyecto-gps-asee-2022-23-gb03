package es.unex.giiis.golaso.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Equipo {

    @SerializedName("Entrenador")
    @Expose
    private String entrenador;

    @SerializedName("Estadio")
    @Expose
    private String estadio;

    @SerializedName("GC")
    @Expose
    private long gc;

    @SerializedName("GF")
    @Expose
    private long gf;

    @SerializedName("Nombre")
    @Expose
    private String nombre;

    @SerializedName("PE")
    @Expose
    private long pe;

    @SerializedName("PG")
    @Expose
    private long pg;

    @SerializedName("PJ")
    @Expose
    private long pj;

    @SerializedName("PP")
    @Expose
    private long pp;

    @SerializedName("PT")
    @Expose
    private long pt;

    @SerializedName("Posicion")
    @Expose
    private long posicion;

    @SerializedName("PosicionAcesso")
    @Expose
    private String posicionAcesso;

    @SerializedName("Ubicacion")
    @Expose
    private String ubicacion;

    @SerializedName("id_equipo")
    @Expose
    private long idEquipo;

    @SerializedName("Logo")
    @Expose
    private String logo;

    public Equipo(long mId, String mNombre, String mEntrenador, String mEstadio,
                  String mUbicacion, String mLogo) {

        this.idEquipo = mId;
        this.nombre = mNombre;
        this.entrenador = mEntrenador;
        this.estadio = mEstadio;
        this.ubicacion = mUbicacion;
        this.logo = mLogo;

    }

    public Equipo(long mId, String mNombre, String mEntrenador, String mEstadio,
                  String mUbicacion, String mLogo, String mPosicionAcesso, long mPosicion,
                  long mGolesFavor, long mGolesContra, long mPartidosJugados,
                  long mPartidosGanados, long mPartidosEmpatados, long mPartidosPerdidos,
                  long mPuntos) {

        this.idEquipo = mId;
        this.nombre = mNombre;
        this.entrenador = mEntrenador;
        this.estadio = mEstadio;
        this.ubicacion = mUbicacion;
        this.logo = mLogo;
        this.posicionAcesso = mPosicionAcesso;
        this.posicion = mPosicion;
        this.gf = mGolesFavor;
        this.gc = mGolesContra;
        this.pj = mPartidosJugados;
        this.pg = mPartidosGanados;
        this.pe = mPartidosEmpatados;
        this.pp = mPartidosPerdidos;
        this.pt = mPuntos;

    }

    public String getLogo() { return logo;}

    public void setLogo(String logo) { this.logo = logo; }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public long getGc() {
        return gc;
    }

    public void setGc(long gc) {
        this.gc = gc;
    }

    public long getGf() {
        return gf;
    }

    public void setGf(long gf) {
        this.gf = gf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPe() {
        return pe;
    }

    public void setPe(long pe) {
        this.pe = pe;
    }

    public long getPg() {
        return pg;
    }

    public void setPg(long pg) {
        this.pg = pg;
    }

    public long getPj() {
        return pj;
    }

    public void setPj(long pj) {
        this.pj = pj;
    }

    public long getPp() {
        return pp;
    }

    public void setPp(long pp) {
        this.pp = pp;
    }

    public long getPt() {
        return pt;
    }

    public void setPt(long pt) {
        this.pt = pt;
    }

    public long getPosicion() {
        return posicion;
    }

    public void setPosicion(long posicion) {
        this.posicion = posicion;
    }

    public String getPosicionAcesso() {
        return posicionAcesso;
    }

    public void setPosicionAcesso(String posicionAcesso) {
        this.posicionAcesso = posicionAcesso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }


}