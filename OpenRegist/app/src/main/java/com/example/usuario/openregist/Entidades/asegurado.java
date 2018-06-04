package com.example.usuario.openregist.Entidades;

public class asegurado {
    private String idAsegurado, nombreAsegurado, cedulaAsegurado, edadAsegurado, fechaNacimientoAsegurado, parentescoAsegurado;

    public asegurado(String idAsegurado, String nombreAsegurado, String cedulaAsegurado, String edadAsegurado, String fechaNacimientoAsegurado, String parentescoAsegurado) {
        this.idAsegurado = idAsegurado;
        this.nombreAsegurado = nombreAsegurado;
        this.cedulaAsegurado = cedulaAsegurado;
        this.edadAsegurado = edadAsegurado;
        this.fechaNacimientoAsegurado = fechaNacimientoAsegurado;
        this.parentescoAsegurado = parentescoAsegurado;
    }

    public String getIdAsegurado() {
        return idAsegurado;
    }

    public void setIdAsegurado(String idAsegurado) {
        this.idAsegurado = idAsegurado;
    }

    public String getNombreAsegurado() {
        return nombreAsegurado;
    }

    public void setNombreAsegurado(String nombreAsegurado) {
        this.nombreAsegurado = nombreAsegurado;
    }

    public String getCedulaAsegurado() {
        return cedulaAsegurado;
    }

    public void setCedulaAsegurado(String cedulaAsegurado) {
        this.cedulaAsegurado = cedulaAsegurado;
    }

    public String getEdadAsegurado() {
        return edadAsegurado;
    }

    public void setEdadAsegurado(String edadAsegurado) {
        this.edadAsegurado = edadAsegurado;
    }

    public String getFechaNacimientoAsegurado() {
        return fechaNacimientoAsegurado;
    }

    public void setFechaNacimientoAsegurado(String fechaNacimientoAsegurado) {
        this.fechaNacimientoAsegurado = fechaNacimientoAsegurado;
    }

    public String getParentescoAsegurado() {
        return parentescoAsegurado;
    }

    public void setParentescoAsegurado(String parentescoAsegurado) {
        this.parentescoAsegurado = parentescoAsegurado;
    }
}
