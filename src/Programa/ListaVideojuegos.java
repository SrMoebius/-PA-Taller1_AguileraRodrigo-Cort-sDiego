package Programa;

import ucn.In;

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


    //Lectura de Archivos
    public void lecturaArchivo(String nombreArchivo) {

        Videojuego nuevoVideojuego;

        In archivoEntrada = new In(nombreArchivo);

        while (!archivoEntrada.isEmpty()) {

            String lista[] = archivoEntrada.readLine().split(",");

            int codigo = Integer.parseInt(lista[0]);
            String nombre = lista[1];
            int precio = Integer.parseInt(lista[2]);
            String genero = lista[3];
            String clasificacionPorEdades = lista[4];
            String desarrolladora = lista[5];
            String plataforma = lista[6];

            nuevoVideojuego = new Videojuego(codigo, nombre, precio, genero, clasificacionPorEdades, desarrolladora, plataforma);

            this.listaVideojuegos[this.cantidadActual++] = nuevoVideojuego;

        }

        archivoEntrada.close();

    }


    //Metodo obtener
    public Videojuego obtener(int posicion) {

        return this.listaVideojuegos[posicion];

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
