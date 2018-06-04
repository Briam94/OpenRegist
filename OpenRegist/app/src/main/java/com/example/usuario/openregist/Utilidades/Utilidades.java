package com.example.usuario.openregist.Utilidades;

public class Utilidades {

    //TABLA USUARIO///////////////

    public static final String TABLA_USUARIO = "usuario";
    public static final String USUARIO_NOMBRE = "nombreusuario";
    public static final String USUARIO_CEDULA = "cedulausuario";
    public static final String USUARIO_CORREO = "correousuario";
    public static final String USUARIO_TELEFONO = "telefonousuario";
    public static final String USUARIO_CONTRASENA = "contrasenausuario";

    public static final String CREAR_TABLA_USUARIO ="CREATE TABLE " + TABLA_USUARIO +" ("+ USUARIO_NOMBRE +" TEXT, "+ USUARIO_CEDULA+" TEXT," +
            USUARIO_CORREO+" TEXT, " + USUARIO_TELEFONO +" TEXT, "+ USUARIO_CONTRASENA +" TEXT)";

    ////// TABLA TITULAR//////////////

    public static final String TABLA_TITULAR = "titular";
    public static final String TITULAR_PLAN = "plantitular";
    public static final String TITULAR_NOMBRE = "nombretitular";
    public static final String TITULAR_CEDULA = "cedulatitular";
    public static final String TITULAR_EDAD = "edadtitular";
    public static final String TITULAR_FECHANACIMIENTO = "fechanacimiento";

    public static final String CREAR_TABLA_TITULAR = "CREATE TABLE " + TABLA_TITULAR + " (" + TITULAR_PLAN + " TEXT, "
            + TITULAR_NOMBRE + " TEXT, " + TITULAR_CEDULA + " TEXT, " + TITULAR_EDAD + " TEXT, " + TITULAR_FECHANACIMIENTO + " TEXT)";

    ///// TABLA ASEGURADO ///////////////////////

    public static final String TABLA_ASEGURADO = "asegurado";
    public static final String ASEGURADO_ID  = "idasegurado";
    public static final String ASEGURADO_NOMBRE = "nombreasegurado";
    public static final String ASEGURADO_CEDULA = "cedulaasegurado";
    public static final String ASEGURADO_EDAD = "edadasegurado";
    public static final String ASEGURADO_FECHANACIMIENTO = "fechanacimientoasegurado";
    public static final String ASEGURADO_PARENTESCO = "parentescoasegurado";

    public static final String CREAR_TABLA_ASEGURADO = "CREATE TABLE " + TABLA_ASEGURADO + " (" + ASEGURADO_ID + " TEXT, "
            + ASEGURADO_NOMBRE + " TEXT, " + ASEGURADO_CEDULA + " TEXT, " + ASEGURADO_EDAD + " TEXT, "
            + ASEGURADO_FECHANACIMIENTO + " TEXT, " + ASEGURADO_PARENTESCO + " TEXT)";

    ///////////TABLA RUTA////////////////////////

    public static final String TABLA_RUTA = "ruta";
    public static final String RUTA_NOMBRE = "nombreruta";
    public static final String RUTA_DIRECCION = "direccionruta";

    public static final String CREAR_TABLA_RUTA = "CREATE TABLE " + TABLA_RUTA + " (" + RUTA_NOMBRE + " TEXT, "
            + RUTA_DIRECCION + " TEXT)";
}
