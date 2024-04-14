package Programa;

public class Videojuego {

    //Atributos
    private int codigo;
    private String nombre;
    private int percio;
    private String genero;
    private String ClasificacionPorEdades;
    private String desarrolladora;
    private String plataforma;


    //Constructor
    public Videojuego(int codigo, String nombre, int percio, String genero, String clasificacionPorEdades, String desarrolladora, String plataforma) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.percio = percio;
        this.genero = genero;
        ClasificacionPorEdades = clasificacionPorEdades;
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

    public int getPercio() {
        return percio;
    }

    public String getGenero() {
        return genero;
    }

    public String getClasificacionPorEdades() {
        return ClasificacionPorEdades;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public String getPlataforma() {
        return plataforma;
    }
}
