package Programa;

import ucn.In;

import java.io.IOException;

public class ListaEmpleados {

    private Empleado[] listaEmpleados;
    private int cantidadMaxima;
    private int cantidadActual;


    public ListaEmpleados(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
        this.listaEmpleados = new Empleado[this.cantidadMaxima];
    }


    /**
     *
     * Función para leer un archivo con los datos de los "trabajadores.txt"
     *
     * Se guardan en la lista de clientes
     *
     *
     */

    void LecturaArchivo() throws IOException {

        Empleado nuevoEmpleado;

        In archivoEntrada = new In("Trabajadores.txt");

        while (!archivoEntrada.isEmpty()){

            String [] separacionEmpleado = archivoEntrada.readLine().split(",");

            String nombre = separacionEmpleado[0];
            String contrasenia = separacionEmpleado[1];

            nuevoEmpleado = new Empleado(nombre,contrasenia,0);

            this.listaEmpleados[this.cantidadActual] = nuevoEmpleado;

            this.cantidadActual++;
        }

        archivoEntrada.close();

    }


    /**
     *
     * Función para buscar un empleado
     * @param nombre
     *
     * @return Devuelve una posicion donde se encuentra el empleado buscado.
     */
    public int buscarEmpleado(String nombre){

        int posicion = -1;

        for(int i=0; i<this.cantidadActual;i++){

            if(this.listaEmpleados[i].getNombreUsuario().equalsIgnoreCase(nombre)){

                posicion = i;
            }

        }
        return posicion;

    }

    public Empleado[] getListaEmpleados() {
        return listaEmpleados;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }


    /**
     *
     * Función para buscar en la lista el empleado con mas ventas
     *
     *
     * @return Devuelve un int con la posicion de el empleado con mas ventas
     */
    public int buscarEmpleadoMasVentas(){

        int posicionEmpleadoMasVentas = -1;

        int cantidadMasVentas =0;

        for(int i=0; i<this.cantidadActual;i++){

            if(this.listaEmpleados[i].getCantidadVentas() > cantidadMasVentas){

               posicionEmpleadoMasVentas = i;
               cantidadMasVentas= listaEmpleados[i].getCantidadVentas();

            }

        }

        return posicionEmpleadoMasVentas;

    }

}
