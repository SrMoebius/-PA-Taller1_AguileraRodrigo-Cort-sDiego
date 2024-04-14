package Programa;

public class Videojuego {


    //Atributos
    private int codigo;
    private String nombre;
    private int precio;
    private String genero;
    private String clasificacionPorEdades;
    private String desarrolladora;
    private String plataforma;


    //Constructor
    public Videojuego(int codigo, String nombre, int precio, String genero, String clasificacionPorEdades, String desarrolladora, String plataforma) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.genero = genero;
        this.clasificacionPorEdades = clasificacionPorEdades;
        this.desarrolladora = desarrolladora;
        this.plataforma = plataforma;
    }


    //Metodos get
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getGenero() {
        return genero;
    }

    public String getClasificacionPorEdades() {
        return clasificacionPorEdades;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public String getPlataforma() {
        return plataforma;
    }
}
