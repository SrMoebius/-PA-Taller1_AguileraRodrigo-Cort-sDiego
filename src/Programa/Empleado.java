package Programa;

public class Empleado {

private String nombreUsuario;
private String contrasena;

private int comicion;

    public Empleado(String nombreUsuario, String contrasena, int comicion) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.comicion = comicion;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getComicion() {
        return comicion;
    }


}
