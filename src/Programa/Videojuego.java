package Programa;

public class Videojuego {

   private int codigo;
   private String nombre;

   private int precio;

   private String genero;

   private String ClasificacionPorEdades;

   private String desarolladora;

   private String plataforma;

    private int cantidadVentas;
    private int montototal;


    public Videojuego(int codigo, String nombre, int precio, String genero, String clasificacionPorEdades, String desarolladora, String plataforma) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.genero = genero;
        this.ClasificacionPorEdades = clasificacionPorEdades;
        this.desarolladora = desarolladora;
        this.plataforma = plataforma;
        this.cantidadVentas = 0;
        this.montototal = 0;

    }

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
        return ClasificacionPorEdades;
    }

    public String getDesarolladora() {
        return desarolladora;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public int getMontototal() {
        return montototal;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public void setMontototal(int montototal) {
        this.montototal = montototal;
    }

    public String empaquetarVideojuego(int posicion){
        String datosVideojuego = "\nCodigo: "+this.getCodigo() +"\nNombre videojuego: "+getNombre() + "\nPrecio: "+getPrecio()+ "\nGenero: "+getGenero();

        return datosVideojuego;

    }




}
