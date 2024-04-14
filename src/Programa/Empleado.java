package Programa;

public class Empleado {


    //Atributos
    private String nombreUsuario;
    private String contrasena;
    private int comision;


    //Constructor
    public Empleado(String nombreUsuario, String contrasena, int comision) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.comision = comision;
    }


    //Metodos get
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getComision() {
        return comision;
    }


}
