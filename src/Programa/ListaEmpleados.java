package Programa;

import ucn.In;

public class ListaEmpleados {


    //Atributos
    private Empleado[] listaEmpleados;
    private int cantidadMaxima;
    private int cantidadActual;


    //Constructor
    public ListaEmpleados(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
        this.listaEmpleados = new Empleado[this.cantidadMaxima];
    }


    //Lectura de Archivos
    public void lecturaArchivo(String nombreArchivo) {

        Empleado nuevoEmpleado;

        In archivoEntrada = new In(nombreArchivo);

        while (!archivoEntrada.isEmpty()) {

            String lista[] = archivoEntrada.readLine().split(",");

            String nombreUsuario = lista[0];
            String contrasenia = lista[1];

            nuevoEmpleado = new Empleado(nombreUsuario, contrasenia, 0);

            this.listaEmpleados[this.cantidadActual++] = nuevoEmpleado;

        }

        archivoEntrada.close();

    }


    //Metodo obtener
    public Empleado obtener(int posicion) {

        return this.listaEmpleados[posicion];

    }


    //Metodos get
    public Empleado[] getListaEmpleados() {
        return listaEmpleados;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }


}
