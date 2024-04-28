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


    /**
     *
     * Método que agrega un nuevo cliente a la listaClientes.
     *
     * @param nuevoCliente
     * @return Devuelve boolean, true si lo agrega correctamente, y false si no.
     */
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


    /**
     *
     * Método para comprobar si un cliente existe o no.
     *
     * @param rut
     * @return Devuelve boolean, true si el cliente existe, y false si no existe.
     */
    public boolean existeCliente(String rut) {

        Cliente clienteActual;

        for (int i = 0; i < this.cantidadActual; i++) {

            clienteActual = this.listaClientes[i];

            if (clienteActual.getRut().equalsIgnoreCase(rut)) {
                return true;
            }

        }

        return false;

    }


    /**
     *
     * Método que toma una posición y devuelve una instancia de tipo Cliente.
     *
     * @param posicion
     * @return Devuelve una instancia de tipo Cliente.
     */
    public Cliente obtenerCliente(int posicion) {

        if (posicion == -1) {
            throw new RuntimeException("El cliente buscado no existe.");
        }

        return this.listaClientes[posicion];

    }


    /**
     *
     * Método para buscar un cliente por su rut.
     *
     * @param rutCliente
     * @return Devuelve la posición en la listaClientes del cliente buscado.
     */
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
