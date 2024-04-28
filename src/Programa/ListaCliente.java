package Programa;

public class ListaCliente {

    private int cantidadMaxima;
    private int cantidadActual;
    private Cliente[] listaClientes;

    private int cantidadVentas;
    private int montoTotalVentas;

    public ListaCliente(int cantidadMaxima) {

        this.cantidadMaxima = cantidadMaxima;
        this.cantidadActual = 0;
        this.listaClientes = new Cliente[this.cantidadMaxima];

        this.cantidadVentas = 0;
        this.montoTotalVentas = 0;

    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public Cliente[] getListaClientes() {
        return listaClientes;
    }


    /**
     *
     * Método para buscar un cliente por su rut.
     *
     * @param rut
     * @return Devuelve un int con la posición donde se encuentra el cliente buscado.
     */
    public int buscarCliente(String rut) {

        int posicion = -1;

        if (cantidadActual == 0) {
            return -1;
        }

        for (int i = 0; i < this.cantidadActual; i++) {

            if (this.listaClientes[i].getRut().equalsIgnoreCase(rut)) {

                posicion = i;

            }

        }

        return posicion;

    }


    /**
     *
     * Método para agregar un cliente, verificando si existe o si la lista permite ingresar un cliente nuevo.
     *
     * @param clientenuevo
     * @return Devuelve un boolean, true si se agregó correctamente, y false si no.
     */
    public boolean AgregarCliente(Cliente clientenuevo) {

        if (this.cantidadActual == this.cantidadMaxima) {
            return false;
        }

        //se guarda el rut del cliente ingresado
        String rutClienteBuscado = clientenuevo.getRut();

        // se verifica que NO exista en la lista, para no repetirse.
        int Verificar = buscarCliente(rutClienteBuscado);

        if (Verificar != -1 ) {

            // el cliente ya existe, por lo tanto...
            return false;

        }


        this.listaClientes[this.cantidadActual] = clientenuevo;
        this.cantidadActual++;

        return true;

    }


    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public int getMontoTotalVentas() {
        return montoTotalVentas;
    }


    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public void setMontoTotalVentas(int montoTotalVentas) {
        this.montoTotalVentas = montoTotalVentas;
    }

}
