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


    public int buscarCliente(String rut){


        int posicion =-1;

        if(cantidadActual == 0){
            return -1;
        }

        for(int i=0; i<this.cantidadActual;i++){

            if(this.listaClientes[i].getRut().equalsIgnoreCase(rut)){

                posicion = i;
            }


        }


return posicion;

    }

    /**
     *
     * Función para agregar un Programa.Cliente, verificando si existe o si la lista permite ingresar un cliente nuevo.
     *
     * @param clientenuevo
     *
     * @return Devuelve un String con el genero random de los videojuegos
     */
    public boolean AgregarCliente(Cliente clientenuevo){

        if(this.cantidadActual == this.cantidadMaxima){
            return false;
        }


        //se guarda el rut del cliente ingresado
        String rutClienteBuscado = clientenuevo.getRut();

        // se verifica que NO exista en la lista, para no repetirse.
        int Verificar = buscarCliente(rutClienteBuscado);

        if(Verificar != -1 ){

            // el cliente ya existe, por lo tanto..
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
