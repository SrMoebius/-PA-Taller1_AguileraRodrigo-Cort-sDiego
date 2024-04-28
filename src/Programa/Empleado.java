package Programa;

public class Empleado {

    private String nombreUsuario;
    private String contrasenia;
    private double comicion;

    private int cantidadVentas;

    public Empleado(String nombreUsuario, String contrasenia, int comicion) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.comicion = 0;
        cantidadVentas = 0;

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public double getComicion() {
        return comicion;
    }

    public void setComicion(double comicion) {
        this.comicion = comicion;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }
}
