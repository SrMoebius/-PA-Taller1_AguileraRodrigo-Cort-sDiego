package Programa;

public class ListaClientes {

    Cliente [] listaClientes;
    int cantidadMaxima;
    int cantidadActual;

    public ListaClientes(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual =0;
        this.listaClientes = new Cliente[this.cantidadMaxima];
    }

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
