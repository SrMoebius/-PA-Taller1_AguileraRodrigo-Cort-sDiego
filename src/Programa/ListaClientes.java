package Programa;

public class ListaClientes {


    //Atributos
    Cliente[] listaClientes;
    int cantidadMaxima;
    int cantidadActual;


    //Constructor
    public ListaClientes(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual =0;
        this.listaClientes = new Cliente[this.cantidadMaxima];
    }


    //Metodos get
    public Cliente[] getListaClientes() {
        return listaClientes;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }


}
