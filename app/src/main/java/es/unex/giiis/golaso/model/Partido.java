package es.unex.giiis.golaso.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Partido {

    @SerializedName("Asistencia")
    @Expose
    public long asistencia;

    @SerializedName("Día")
    @Expose
    public String día;

    @SerializedName("Estadio")
    @Expose
    public String estadio;

    @SerializedName("Fecha")
    @Expose
    public String fecha;

    @SerializedName("Hora")
    @Expose
    public String hora;

    @SerializedName("Jornada")
    @Expose
    public long jornada;

    @SerializedName("Local")
    @Expose
    public String local;

    @SerializedName("Marcador")
    @Expose
    public String marcador;

    @SerializedName("Visitante")
    @Expose
    public String visitante;

    @SerializedName("id_local")
    @Expose
    public long id_local;

    @SerializedName("id_visitante")
    @Expose
    public long id_visitante;

    public Partido(long id_local, long id_visitante, String local, String visitante, String marcador,
                   String estadio, String fecha, String hora, String día, long asistencia,
                   long jornada){

        this.id_local = id_local;
        this.id_visitante = id_visitante;
        this.local = local;
        this.visitante = visitante;
        this.marcador = marcador;
        this.estadio = estadio;
        this.fecha = fecha;
        this.hora = hora;
        this.día = día;
        this.asistencia = asistencia;
        this.jornada = jornada;

    }

    public long getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(long asistencia) {
        this.asistencia = asistencia;
    }

    public String getDía() {
        return día;
    }

    public void setDía(String día) {
        this.día = día;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public long getJornada() {
        return jornada;
    }

    public void setJornada(long jornada) {
        this.jornada = jornada;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public long getId_local() {
        return id_local;
    }

    public void setId_local(long id_local) {
        this.id_local = id_local;
    }

    public long getId_visitante() {
        return id_visitante;
    }

    public void setId_visitante(long id_visitante) {
        this.id_visitante = id_visitante;
    }
}
