package Programa;

public class ListaEmpleados {

    private Empleado [] listaEmpleados;
    private int cantidadMaxima;
    private int cantidadActual;

    public ListaEmpleados(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
        this.listaEmpleados = new Empleado[this.cantidadMaxima];
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


}
