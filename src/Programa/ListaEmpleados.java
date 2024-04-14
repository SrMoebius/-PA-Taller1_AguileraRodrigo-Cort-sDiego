package Programa;

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
