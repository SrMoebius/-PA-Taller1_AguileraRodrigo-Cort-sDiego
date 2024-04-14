package Programa;

public class Cliente {


    //Atributos
    private String rut;
    private String nombre;
    private String email;


    //Constructor
    public Cliente(String rut, String nombre, String email) {
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
    }


    //Metodos get
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
