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


    public boolean agregarCliente(Cliente nuevoCliente) {

        //se guarda el rut del cliente ingresado
       String rutClienteBuscado = nuevoCliente.getRut();

       // se verifica que NO exista en la lista, para no repetirse.
       int Verificar = buscarCliente(rutClienteBuscado);

       if(Verificar != -1 ){

           // el cliente ya existe, por lo tanto..
           return false;
       }


        this.listaClientes[this.cantidadActual++] = nuevoCliente;
        return true;

    }

    //TODO: Crear método para saber si un cliente existe o no


    public Cliente obtenerCliente(int posicion) {

        if (posicion == -1) {
            throw new RuntimeException("El cliente buscado no existe.");
        }

        return this.listaClientes[posicion];

    }


    public int buscarCliente(String rutCliente) {

        Cliente clienteActual;

        for (int i = 0; i < this.cantidadActual; i++) {

            clienteActual = this.listaClientes[i];

            if (clienteActual.getRut().equalsIgnoreCase(rutCliente)) {

                return i;

            }

        }

        return -1;

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
