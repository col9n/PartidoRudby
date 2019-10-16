package com.models;

import java.io.Serializable;
import java.util.Date;

/*
De cada partido de rugby se almacenará la siguiente información.
◦ Equipo local (cadena de texto)
◦ Equipo visitante (cadena de texto)
◦ División. A seleccionar entre primera, segunda o tercera.
◦ Resultado (formato número-número, por ejemplo, 23-34).
◦ Fecha (en formato 30-10-2017).
 */
public class Partido implements Comparable<Partido> ,Serializable {

    String local;
    String visitante;
   division div;

    @Override
    public int compareTo(Partido partido) {
        return 0;
    }

    public enum division
    {
       PRIEMRA,SEGUNDA,TERCERA
    }
    Date fecha;
    String resultadoLocal;
    String resultadoVisitante;

    public Partido(String local, String visitante, division div, Date fecha, String resultadoLocal,String resultadoVisitante) {
        this.local = local;
        this.visitante = visitante;
        this.div = div;
        this.fecha = fecha;
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public division getDiv() {
        return div;
    }

    public void setDiv(division div) {
        this.div = div;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(String resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public String getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(String resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "local='" + local + '\'' +
                ", visitante='" + visitante + '\'' +
                ", div=" + div +
                ", fecha=" + fecha +
                ", resultadoLocal='" + resultadoLocal + '\'' +
                ", resultadoVisitante='" + resultadoVisitante + '\'' +
                '}';
    }
}
