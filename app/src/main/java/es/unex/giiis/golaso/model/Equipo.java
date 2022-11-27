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
    private Integer gc;

    @SerializedName("GF")
    @Expose
    private Integer gf;

    @SerializedName("Nombre")
    @Expose
    private String nombre;

    @SerializedName("PE")
    @Expose
    private Integer pe;

    @SerializedName("PG")
    @Expose
    private Integer pg;

    @SerializedName("PJ")
    @Expose
    private Integer pj;

    @SerializedName("PP")
    @Expose
    private Integer pp;

    @SerializedName("PT")
    @Expose
    private Integer pt;

    @SerializedName("Posicion")
    @Expose
    private Integer posicion;

    @SerializedName("PosicionAcesso")
    @Expose
    private String posicionAcesso;

    @SerializedName("Ubicacion")
    @Expose
    private String ubicacion;

    @SerializedName("id_equipo")
    @Expose
    private Integer idEquipo;

    @SerializedName("Logo")
    @Expose
    private String logo;

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

    public Integer getGc() {
        return gc;
    }

    public void setGc(Integer gc) {
        this.gc = gc;
    }

    public Integer getGf() {
        return gf;
    }

    public void setGf(Integer gf) {
        this.gf = gf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPe() {
        return pe;
    }

    public void setPe(Integer pe) {
        this.pe = pe;
    }

    public Integer getPg() {
        return pg;
    }

    public void setPg(Integer pg) {
        this.pg = pg;
    }

    public Integer getPj() {
        return pj;
    }

    public void setPj(Integer pj) {
        this.pj = pj;
    }

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public Integer getPt() {
        return pt;
    }

    public void setPt(Integer pt) {
        this.pt = pt;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
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

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

}