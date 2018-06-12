package com.example.usuario.openregist.Entidades;

public class titular {

    private String plan, nombreTitular, cedulaTitular, edadTitular, fechaNacimientoTitular;

    public titular(String plan, String nombreTitular, String cedulaTitular, String edadTitular, String fechaNacimientoTitular) {
        this.plan = plan;
        this.nombreTitular = nombreTitular;
        this.cedulaTitular = cedulaTitular;
        this.edadTitular = edadTitular;
        this.fechaNacimientoTitular = fechaNacimientoTitular;
    }

    public titular() {

    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getCedulaTitular() {
        return cedulaTitular;
    }

    public void setCedulaTitular(String cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }

    public String getEdadTitular() {
        return edadTitular;
    }

    public void setEdadTitular(String edadTitular) {
        this.edadTitular = edadTitular;
    }

    public String getFechaNacimientoTitular() {
        return fechaNacimientoTitular;
    }

    public void setFechaNacimientoTitular(String fechaNacimientoTitular) {
        this.fechaNacimientoTitular = fechaNacimientoTitular;
    }
}
