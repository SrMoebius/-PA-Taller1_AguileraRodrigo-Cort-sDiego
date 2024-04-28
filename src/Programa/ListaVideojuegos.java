package Programa;

import ucn.*;
import java.io.IOException;

public class ListaVideojuegos {

    private int cantidadMaxima;
    private int cantidadActual;

    private int cantidadNintendo = 0;
    private int cantidadPlaystation = 0;
    private int cantidadXbox = 0;

    private Videojuego[] listaVideojuegos;


    public ListaVideojuegos(int cantidadMaxima) {

        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
        this.listaVideojuegos = new Videojuego[this.cantidadMaxima];

        this.cantidadNintendo =0;
        this.cantidadXbox = 0;
        this.cantidadPlaystation = 0;

    }


    public Videojuego[] getListaVideojuegos() {
        return listaVideojuegos;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }


    /**
     *
     * Método para realizar la lectura de archivos de los Videojuegos.
     *
     * @throws IOException
     */
    public void LecturaArchivo() throws IOException {

        Videojuego nuevoVideojuego;

        In archivoEntrada = new In("Juegos.txt");

        while (!archivoEntrada.isEmpty()) {

            String[] separacionVideojuego = archivoEntrada.readLine().split(",");

            int codigo = Integer.parseInt(separacionVideojuego[0]);
            String nombre = separacionVideojuego[1];
            int precio = Integer.parseInt(separacionVideojuego[2]);
            String genero = separacionVideojuego[3];
            String clasificacionPorEdades = separacionVideojuego[4];
            String desarolladora = separacionVideojuego[5];
            String plataforma = separacionVideojuego[6];

            nuevoVideojuego = new Videojuego(codigo,nombre,precio,genero,clasificacionPorEdades,desarolladora,plataforma);

            this.listaVideojuegos[this.cantidadActual] = nuevoVideojuego;
            this.cantidadActual++;

        }

        archivoEntrada.close();

    }


    /**
     *
     * Método para buscar un videojuego por su código.
     *
     * @param codigo
     * @return Devuelve la posición del videojuego buscado.
     */
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


    /**
     *
     * Método para buscar un videojuego por su nombre.
     *
     * @param nombreVideojuego
     * @return Devuelve la posición del videojuego buscado.
     */
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


    /**
     *
     * Método para crear una lista con los géneros de los videojuegos (sin repetirse),
     *  eligiendo un género aleatorio.
     *
     * @return Devuelve un String con un género random de los videojuegos.
     */
    public String generoEnOferta() {

        String[] listaGeneros = new String[30];
        int contador =0;

        for (int i = 0; i < this.cantidadActual; i++) {

            boolean existe = false;

            for (int j = 0; j < contador; j++) {

                if (listaVideojuegos[i].getGenero().equalsIgnoreCase(listaVideojuegos[j].getGenero())) {

                    existe = true;

                }

            }

            if (existe == false) {

                listaGeneros[contador] = listaVideojuegos[i].getGenero();
                contador++;

            }

        }

        int posicionRandom = (int) (Math.random() * contador+1);

        String generoOferta = listaGeneros[posicionRandom];

        return generoOferta;

    }


    /**
     *
     * Método que crea un String con la toda información de un videojuego.
     *
     * @param posicion
     * @return Devuelve un String con el genero random de los videojuegos.
     */
    public String empaquetarVideojuego (int posicion) {

        //videojuego encontrado
        Videojuego videojuego = this.listaVideojuegos[posicion];


        String instanciaVideojuego = "Codigo unico: "+videojuego.getCodigo()+" \nNombre: "+videojuego.getNombre()+
                " \nPrecio: "+videojuego.getPrecio() + "\nGenero: "+videojuego.getGenero() +" \nClasificacion: "+videojuego.getClasificacionPorEdades()+
                " \nDesarolladora: "+videojuego.getGenero() + " \nPlataforma: "+videojuego.getPlataforma()+" \nCantidad de ventas: "+videojuego.getCantidadVentas()+
                " \nMonto Total: "+videojuego.getMontototal()+" \n";

        return instanciaVideojuego;

    }


    /**
     *
     * Método para buscar en la lista, el videojuego más vendido.
     *
     * @return Devuelve un int con la posición del videojuego con mayores ventas totales.
     */
    public int buscarCantidadMaximaVendida() {

        int cantidadMaximaVendida = 0;

        for (int i = 0; i < this.cantidadActual; i++) {

            if (this.listaVideojuegos[i].getCantidadVentas() > cantidadMaximaVendida) {

                cantidadMaximaVendida = listaVideojuegos[i].getCantidadVentas();

            }

        }

        return cantidadMaximaVendida;

    }


    /**
     *
     * Método para calcular el monto total de dinero que se ha recaudado con las ventas.
     *
     * @return Devuelve un int con el monto total de las ventas.
     */
    public int montoTotal() {

        int montototalTienda=0;

        for (int i = 0; i < this.cantidadActual; i++) {

            montototalTienda += this.listaVideojuegos[i].getMontototal();

        }

        return montototalTienda;

    }


    public int getCantidadNintendo() {
        return cantidadNintendo;
    }

    public int getCantidadPlaystation() {
        return cantidadPlaystation;
    }

    public int getCantidadXbox() {
        return cantidadXbox;
    }


    public void setCantidadNintendo(int cantidadNintendo) {
        this.cantidadNintendo = cantidadNintendo;
    }

    public void setCantidadPlaystation(int cantidadPlaystation) {
        this.cantidadPlaystation = cantidadPlaystation;
    }

    public void setCantidadXbox(int cantidadXbox) {
        this.cantidadXbox = cantidadXbox;
    }
}
