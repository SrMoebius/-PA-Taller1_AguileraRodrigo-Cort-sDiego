package Programa;

import ucn.In;
import ucn.StdOut;

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

        if (posicion == -1) {
            throw new RuntimeException("El juego buscado no existe.");
        }

        return this.listaVideojuegos[posicion];

    }

    public boolean agregarVideojuego(Videojuego nuevoVideojuego) {

        this.listaVideojuegos[this.cantidadActual++] = nuevoVideojuego;
        return true;

    }


    //Buscar juego por código
    public int buscarVideojuego(int codigo) {

        Videojuego videojuegoActual;

        for (int i = 0; i < this.cantidadActual; i++) {

            videojuegoActual = this.listaVideojuegos[i];

            if (videojuegoActual.getCodigo() == codigo) {

                return i;

            }

        }

        return -1;

    }


    //Buscar juego por nombre
    public int buscarVideojuego(String nombreVideojuego) {

        Videojuego videojuegoActual;

        for (int i = 0; i < this.cantidadActual; i++) {

            videojuegoActual = this.listaVideojuegos[i];

            if (videojuegoActual.getNombre().equalsIgnoreCase(nombreVideojuego)) {

                return i;

            }

        }

        return -1;

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
