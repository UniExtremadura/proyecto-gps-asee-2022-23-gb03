package es.unex.giiis.golaso.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Partido {

    @SerializedName("Asistencia")
    @Expose
    public int asistencia;

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
    public int jornada;

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
    public int id_local;

    @SerializedName("id_visitante")
    @Expose
    public int id_visitante;

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
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

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
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

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public int getId_visitante() {
        return id_visitante;
    }

    public void setId_visitante(int id_visitante) {
        this.id_visitante = id_visitante;
    }
}
