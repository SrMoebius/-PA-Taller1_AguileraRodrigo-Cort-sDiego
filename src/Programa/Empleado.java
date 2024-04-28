package Programa;

public class Empleado {

    private String nombreUsuario;
    private String contrasenia;
    private int comicion;

    private int cantidadVentas;


    public Empleado(String nombreUsuario, String contrasenia, int comicion) {

        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.comicion = 0;

        this.cantidadVentas = 0;

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

    public void setComicion(int comicion) {
        this.comicion = comicion;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

}
