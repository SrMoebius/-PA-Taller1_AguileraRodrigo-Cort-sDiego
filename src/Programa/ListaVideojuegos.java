package Programa;

public class ListaVideojuegos {


    //Atributos
    private Videojuego[] listaVideojuegos;
    private int cantidadMaxima;
    private int cantidadActual;


    //Constructor
    public ListaVideojuegos(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
        this.listaVideojuegos = new Videojuego[this.cantidadMaxima];
    }


    //Metodos get
    public Videojuego[] getListaVideojuegos() {
        return listaVideojuegos;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }
}
