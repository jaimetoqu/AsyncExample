package com.jaimetoqu.asyncexample.models;

public class Wrapper {

    private String fecha;
    private String autor;
    private String version;
    private Indicator uf;
    private Indicator[] serie;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Indicator getUf() {
        return uf;
    }

    public void setUf(Indicator uf) {
        this.uf = uf;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Indicator[] getSerie() {
        return serie;
    }

    public void setSerie(Indicator[] serie) {
        this.serie = serie;
    }
}
