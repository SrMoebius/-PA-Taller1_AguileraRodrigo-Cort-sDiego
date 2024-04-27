package Programa;

import ucn.*;

public class Main {
    public static void main(String[] args) {

        menu();

    }


    public static void menu() {

        //TODO: Calcular Estadísticas


        //LECTURA DE ARCHIVOS
        ListaEmpleados listaEmpleados = new ListaEmpleados(5);
        listaEmpleados.lecturaArchivo("Trabajadores.txt");

        //prueba para comprobar que la lectura se realizó con éxito
        //mostrarEmpleados(listaEmpleados);


        ListaVideojuegos listaVideojuegos = new ListaVideojuegos(10);
        listaVideojuegos.lecturaArchivo("Juegos.txt");

        //prueba para comprobar que la lectura se realizó con éxito
        //mostrarVideojuegos(listaVideojuegos);

        ListaClientes listaClientes = new ListaClientes(999);
        Cliente clientePrueba = new Cliente("21.760.570-9", "Rodrigo", "rodrigo@gmail.com");
        listaClientes.agregarCliente(clientePrueba);


        //Se crea una lista que guarde los generos de videojuegos sin repetirse
        String[] listaGeneroVideojuegos = listaGeneroVideojuegos(listaVideojuegos);
        int contGeneros = listaGeneroVideojuegos.length;

        //Toma la lista de géneros y elige uno de manera aleatoria
        String generoVideojuegoConDescuento = videojuegoAleatorio(listaGeneroVideojuegos, contGeneros);
        StdOut.println(generoVideojuegoConDescuento);


        String CONTINUAR = "";


        boolean menuActivado = true;

        while (menuActivado != false) {

            StdOut.println("""
                    \n**************************************************
                    * Bienvenido al Sistema de Ventas de Videojuegos *
                    **************************************************
                    Identifícate:
                    [1] Iniciar Sesión
                    [2] Cerrar Programa""");

            StdOut.print("\nElija una opción: ");
            int opcion = validarOpcion();

            switch (opcion){


                case 1 -> {

                    IniciarSesion(listaEmpleados,listaVideojuegos,listaClientes,generoVideojuegoConDescuento);

                    StdOut.print("\npresione ENTER para continuar");
                    CONTINUAR = StdIn.readString();

                }

                case 2 -> {

                    StdOut.println("\nCerrar Programa");
                    menuActivado = false;

                }

                default -> {

                    StdOut.println("\nLa opción " + opcion + ", no es una opcion del menú");

                    StdOut.print("\npresione ENTER para continuar");
                    CONTINUAR = StdIn.readString();

                }

            }

        }

    }


    public static int validarOpcion() {

        String opcionTexto;

        boolean condicion = false;
        int opcion = 0;

        do {

            try {

                opcionTexto = StdIn.readString();
                opcion = Integer.parseInt(opcionTexto);
                condicion = true;
                return opcion;

            } catch (Exception exception) {

                StdOut.println("\nIngrese un valor numérico.");
                StdOut.print("Ingrese una opción: ");

            }

        } while (condicion != true);

        return opcion;

    }

    public static void mostrarEmpleados(ListaEmpleados listaEmpleados) {

        Empleado empleadoActual;

        for (int i = 0; i < listaEmpleados.getCantidadActual(); i++) {

            empleadoActual = listaEmpleados.obtener(i);

            StdOut.println("\n::: Empleado N°" + (i+1) + " :::");

            StdOut.println("Nombre de Usuario: " + empleadoActual.getNombreUsuario());
            StdOut.println("Contraseña: " + empleadoActual.getContrasena());
            StdOut.println("Comisiónes: $" + empleadoActual.getComision());

        }

    }

    public static void mostrarVideojuegos(ListaVideojuegos listaVideojuegos) {

        Videojuego videojuegoActual;

        for (int i = 0; i < listaVideojuegos.getCantidadActual(); i++) {

            videojuegoActual = listaVideojuegos.obtener(i);

            StdOut.println("\n::: Videojuego N°" + (i+1) + " :::");

            StdOut.println("Código: " + videojuegoActual.getCodigo());
            StdOut.println("Nombre: " + videojuegoActual.getNombre());
            StdOut.println("Precio: $" + videojuegoActual.getPrecio());
            StdOut.println("Género: " + videojuegoActual.getGenero());
            StdOut.println("Clasificación por Edades: " + videojuegoActual.getClasificacionPorEdades());
            StdOut.println("Desarrolladora: " + videojuegoActual.getDesarrolladora());
            StdOut.println("Plataforma: " + videojuegoActual.getPlataforma());

        }

    }

    public static boolean comprobarUsuario(ListaEmpleados listaEmpleados, String nombreUsuario, String contrasenia) {

        boolean sesionIniciada = false;
        Empleado empleadoActual;

        for (int i = 0; i < listaEmpleados.getCantidadActual(); i++) {

            empleadoActual = listaEmpleados.obtener(i);

            if (empleadoActual.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {

                if (empleadoActual.getContrasena().equalsIgnoreCase(contrasenia)) {

                    sesionIniciada = true;
                    return sesionIniciada;

                }

            }

        }

        return sesionIniciada;

    }

    public static boolean comprobarCliente(ListaClientes listaClientes, String rut) {

        return listaClientes.existeCliente(rut);

    }

    public static boolean comprobarJuego(ListaVideojuegos listaVideojuegos, String nombreJuegoVendido) {

        boolean sesionIniciada = false;
        Videojuego videojuegoActual;

        for (int i = 0; i < listaVideojuegos.getCantidadActual(); i++) {

            videojuegoActual = listaVideojuegos.obtener(i);

            if (videojuegoActual.getNombre().equalsIgnoreCase(nombreJuegoVendido)) {

                sesionIniciada = true;
                return sesionIniciada;

            }

        }

        return sesionIniciada;

    }

    public static void mostrarDatosVideojuego(Videojuego videojuego) {

        StdOut.println("\nCódigo: " + videojuego.getCodigo());
        StdOut.println("Nombre: " + videojuego.getNombre());
        StdOut.println("Precio: $" + videojuego.getPrecio());
        StdOut.println("Género: " + videojuego.getGenero());
        StdOut.println("Clasificación por Edades: " + videojuego.getClasificacionPorEdades());
        StdOut.println("Desarrolladora: " + videojuego.getDesarrolladora());
        StdOut.println("Plataforma: " + videojuego.getPlataforma());

    }

    private static String[] listaGeneroVideojuegos(ListaVideojuegos listaVideojuegos) {


        //Creo una lista "momentanea", para guardar los nombres de los géneros (sin que se repitan)
        //pero no logro obtener la  cantidad de géneros totales, por lo que creo al variable "cont" para hacerlo
        String[] lista = new String[listaVideojuegos.getCantidadActual()];
        int cont = 0;

        Videojuego videojuego1;
        Videojuego videojuego2;

        boolean existe = false;

        for (int i = 0; i < listaVideojuegos.getCantidadActual(); i++) {
            
            videojuego1 = listaVideojuegos.obtener(i);
            
            existe = false;

            for (int j = 0; j < cont; j++) {

                videojuego2 = listaVideojuegos.obtener(j);

                if (videojuego1.getGenero().equalsIgnoreCase(videojuego2.getGenero())) {

                    existe = true;
                    continue;

                }
                
            }

            if (existe == false) {

                lista[cont++] = videojuego1.getGenero();

            }
            
            
        }

        //Ahora que la lista está terminada, tengo la cantidad real de cantidad de géneros,
        // por lo que creo una lista nueva, con dicha cantidad de géneros, y copio los nombre de los géneros a la nueva lista.
        String[] listaGeneroVideojuegos = new String[cont];
        for (int i = 0; i < cont; i++) {

            listaGeneroVideojuegos[i] = lista[i];

        }

        //Y devuelvo esta nueva lista
        return listaGeneroVideojuegos;

    }


    /**
     *
     * Función para realizar el descuento a un genero de videojuego (que se encuentra en la lista) de
     * manera aleatoria, se ingresa la lista de generos de videojuegos con la cantidad existentes de generos.
     *
     * @param listaGeneroVideojuegos
     * @param contGeneros
     * @return Devuelve un String con el nombre del género escogido aleatoriamente.
     */
    public static String videojuegoAleatorio(String[] listaGeneroVideojuegos, int contGeneros) {

        String generoConDescuento = "";

        int posicionRandom = (int)(Math.random()*(contGeneros));

        StdOut.println(posicionRandom);

        generoConDescuento = listaGeneroVideojuegos[posicionRandom];

        return generoConDescuento;

    }

    public static int devolverPrecio(ListaVideojuegos listaVideojuegos, String nombreVideojuego) {

        Videojuego videojuegoComprado;

        for (int i = 0; i < listaVideojuegos.getCantidadActual(); i++) {

            videojuegoComprado = listaVideojuegos.obtener(i);

            if (videojuegoComprado.getNombre().equalsIgnoreCase(nombreVideojuego)) {

                return videojuegoComprado.getPrecio();

            }

        }

        return -1;

    }

    public static Empleado empleadoSesionActual(ListaEmpleados listaEmpleados, String nombreUsuario) {

        Empleado empleadoActual;

        for (int i = 0; i < listaEmpleados.getCantidadActual(); i++) {

            empleadoActual = listaEmpleados.obtener(i);

            if (empleadoActual.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {

                return empleadoActual;

            }

        }

        return null;

    }

    public static String generoVideojuegoComprado(ListaVideojuegos listaVideojuegos, String nombreJuego) {

        Videojuego videojuegoComprado;

        for (int i = 0; i < listaVideojuegos.getCantidadActual(); i++) {

            videojuegoComprado = listaVideojuegos.obtener(i);

            if (videojuegoComprado.getNombre().equalsIgnoreCase(nombreJuego)) {

                return videojuegoComprado.getGenero();

            }

        }

        return null;

    }



    public static void IniciarSesion(ListaEmpleados listaEmpleados, ListaVideojuegos listaVideojuegos, ListaClientes listaClientes, String generoVideojuegoConDescuento){{

        String CONTINUAR;

        StdOut.print("\nIngrese su nombre de usuario: ");
        String nombreUsuario = StdIn.readString();

        StdOut.print("Ingrese su contraseña: ");
        String contrasenia = StdIn.readString();

        if (comprobarUsuario(listaEmpleados, nombreUsuario, contrasenia)) {

            int opcion2 = 0;

            while (opcion2 != 4) {


                StdOut.println("""
                                    \n********************
                                        MENU PRINCIPAL
                                    ********************
                                    [1] Vender Videojuego
                                    [2] Buscar Videojuego
                                    [3] Menu Estadísticas
                                    [4] Cerrar Sesión""");

                StdOut.print("\nElige una opción: ");
                opcion2 = validarOpcion();


                switch (opcion2) {

                    case 1 -> {

                        VenderVideojuego(listaVideojuegos,listaClientes,listaEmpleados,generoVideojuegoConDescuento,nombreUsuario);

                        StdOut.print("\npresione ENTER para continuar");
                        CONTINUAR = StdIn.readString();

                    }

                    case 2 -> {

                        buscarVideojuego(listaVideojuegos,listaEmpleados);

                        StdOut.print("\npresione ENTER para continuar");
                        CONTINUAR = StdIn.readString();

                    }

                    case 3 -> {

                        StdOut.println("\nMenu Estadísticas");

                        menuEstadisticas();

                        StdOut.print("\npresione ENTER para continuar");
                        CONTINUAR = StdIn.readString();

                    }

                    case 4 -> {

                        StdOut.println("\nSesión Cerrada con éxito.");

                    }

                    default -> {

                        StdOut.println("\nLa opción " + opcion2 + ", no es una opción del menú");

                        StdOut.print("\npresione ENTER para continuar");
                        CONTINUAR = StdIn.readString();

                    }


                }


            }

        } else {

            StdOut.println("\nEl nombre de usuario o la contraseña son incorrectas.");

        }

    }
 }

    private static void menuEstadisticas() {

        boolean menu = false ;// se crea el menu con un ciclo while

        while (!menu){

            StdOut.println("""
                                    \n**********************
                                       MENU ESTADISTICAS
                                    ***********************
                                    [1] Videojuego más vendido
                                    [2] Plataforma con mayor ventas
                                    [3] Venta a clientes registrados
                                    [4] Imprimir ventas totales
                                    [5] Trabajador con más ventas
                                    [6] Menú anterior""");

            StdOut.print("Opcion: ");
            int opcion = validarOpcion();

            switch (opcion) {

                // Estadistica videojuego mas vendido
                case 1 ->{


                }












            }

        }


    }

    public static void VenderVideojuego(ListaVideojuegos listaVideojuegos,ListaClientes listaClientes,ListaEmpleados listaEmpleados,String generoVideojuegoConDescuento,String nombreUsuario){

        StdOut.print("\nIngrese el nombre del videojuego a vender: ");
        String videojuegoVenta = StdIn.readString();

        //Comprueba de que se ingresó un nombre de videojuego existente.
        if (comprobarJuego(listaVideojuegos, videojuegoVenta)) {

            StdOut.println("""
                        ¿Es usted miembro?
                        [1] SI
                        [2] NO""");

            StdOut.print("Elija una opción: ");
            int opcionMiembro = validarOpcion();

            //Caso en que diga que si es cliente.
            if (opcionMiembro == 1) {

                StdOut.print("\nIngrese su rut: ");
                String rutCliente = StdIn.readString();

                //Caso en que diga que si es cliente, y si sea cliente.
                if (comprobarCliente(listaClientes, rutCliente)) {

                    StdOut.println("\nGenial!, como es miembro, se le aplican descuentos dependiendo del género del juego que compre.");

                    String generoVideojuegoComprado = generoVideojuegoComprado(listaVideojuegos, videojuegoVenta);

                    StdOut.println("\nEl genero del videojuego a comprar es: "+generoVideojuegoComprado);
                    StdOut.println("\nEl genero con descuento es: "+generoVideojuegoConDescuento);

                    //Caso en el que el género SI coincida con el género con descuento.
                    if (generoVideojuegoComprado.equalsIgnoreCase(generoVideojuegoConDescuento)) {


                        StdOut.println("En este caso, si aplica, por lo que usted obtiene un descuento del 30%.");

                        //Metodo que devuelva el empleado en la sesión actual.
                        Empleado empleadoSesionActual = empleadoSesionActual(listaEmpleados,nombreUsuario);

                        int precioVideojuegoActual = devolverPrecio(listaVideojuegos, videojuegoVenta);

                        StdOut.println("\nPrecio anterior: $" + precioVideojuegoActual);
                        StdOut.println("Precio con descuento: $" + (precioVideojuegoActual * 0.7));

                        //Impresión por pantalla solo para comprobar que la suma de la comisión funcione.
                        StdOut.println("Empleado: " + empleadoSesionActual.getNombreUsuario() + " --> Comisión anterior: $" + empleadoSesionActual.getComision());
                        //El empleado se lleva un 2% del precio del juego.
                        empleadoSesionActual.setComision((int) (precioVideojuegoActual * 0.02));
                        StdOut.println("Empleado: " + empleadoSesionActual.getNombreUsuario() + " --> Comisión actual: $" + empleadoSesionActual.getComision());

                        StdOut.println("\nVenta realizada con éxito! :)");


                    //Caso en le que el género NO coincida con el género con descuento.
                    } else {


                        StdOut.println("En este caso, no aplica, por lo que usted no obtiene el descuento del 30%.");

                        //Metodo que devuelva el empleado en la sesión actual.
                        Empleado empleadoSesionActual = empleadoSesionActual(listaEmpleados, nombreUsuario);

                        int precioVideojuegoActual = devolverPrecio(listaVideojuegos, videojuegoVenta);

                        StdOut.println("\nPrecio: $" + precioVideojuegoActual);

                        //Impresión por pantalla solo para comprobar que la suma de la comisión funcione.
                        StdOut.println("Empleado: " + empleadoSesionActual.getNombreUsuario() + " --> Comisión anterior: $" + empleadoSesionActual.getComision());
                        //El empleado se lleva un 2% del precio del juego.
                        empleadoSesionActual.setComision((int) (precioVideojuegoActual * 0.02));
                        StdOut.println("Empleado: " + empleadoSesionActual.getNombreUsuario() + " --> Comisión actual: $" + empleadoSesionActual.getComision());

                        StdOut.println("\nVenta realizada con éxito! :)");


                    }

                //Caso en que diga que si es cliente, pero no sea en realidad.
                } else{

                    StdOut.println("\nLamentablemente usted, no es cliente de esta tienda.");

                }

            //Caso en que diga que no es cliente.
            } else if (opcionMiembro == 2) {

                StdOut.println("""
                                ¿Deseas ser miembro?
                                [1] SI
                                [2] NO""");

                StdOut.print("\nElige una opción: ");
                int opcionNoMienbro = validarOpcion();

                //Caso en el que decida ser miembro
                if (opcionNoMienbro == 1) {

                    StdOut.println("\nGenial!");

                    StdOut.print("\nComience ingresando su rut: ");
                    String rut = StdIn.readString();

                    StdOut.print("Ingrese su nombre: ");
                    String nombre = StdIn.readString();

                    StdOut.print("Ingrese su correo: ");
                    String correo = StdIn.readString();

                    Cliente nuevoCliente = new Cliente(rut, nombre, correo);

                    if (listaClientes.agregarCliente(nuevoCliente)) {
                        StdOut.println("\nCliente agregado con éxito!");

                        StdOut.print("\nDebe volver al menu y realizar la compra correctamente.");

                    } else {
                        StdOut.println("\nEl cliente ingresado ya existe.");
                    }
                    else if(!listaClientes.agregarCliente(nuevoCliente)){

                        StdOut.println("Estimado usuario, el usuario con este rut ya existe");
                    }

                //Caso en el que decida NO ser miembro
                } else if (opcionNoMienbro == 2) {

                    StdOut.println("\nNo hay problema!");

                    StdOut.println("\nComo no es miembro, no se le aplican descuentos.");

                    //Metodo que devuelva el empleado en la sesión actual.
                    Empleado empleadoSesionActual = empleadoSesionActual(listaEmpleados, nombreUsuario);

                    int precioVideojuegoActual = devolverPrecio(listaVideojuegos, videojuegoVenta);

                    StdOut.println("\nPrecio: $" + precioVideojuegoActual);

                    //Impresión por pantalla solo para comprobar que la suma de la comisión funcione.
                    StdOut.println("Empleado: " + empleadoSesionActual.getNombreUsuario() + " --> Comisión anterior: $" + empleadoSesionActual.getComision());
                    //El empleado se lleva un 2% del precio del juego.
                    empleadoSesionActual.setComision((int) (precioVideojuegoActual * 0.02));
                    StdOut.println("Empleado: " + empleadoSesionActual.getNombreUsuario() + " --> Comisión actual: $" + empleadoSesionActual.getComision());

                    StdOut.println("\nVenta realizada con éxito! :)");

                } else {

                    StdOut.println("\nLa opción " + opcionNoMienbro + ", no es una opcion del menú");

                }

                //Caso en que eliga una opción inválida.
            } else {

                StdOut.println("\nLa opción " + opcionMiembro + ", no es una opcion del menú");

            }

        //Caso en que el juego ingresado sea inválido.
        } else {

            StdOut.println("\nEl juego ingresado no existe.");

        }
    }



    public static void buscarVideojuego(ListaVideojuegos listaVideojuegos,ListaEmpleados listaEmpleados){

        StdOut.println("""
                                            \n:::Opciones de busqueda:::
                                            1) Buscar por código
                                            2) Buscar por nombre""");

        StdOut.print("Elija una opción: ");
        int opcionBusqueda = validarOpcion();

        if (opcionBusqueda == 1) {

            StdOut.print("\nIngrese el código del videojuego: ");
            int codigo = validarOpcion();

            int posicion = listaVideojuegos.buscarVideojuego(codigo);

            Videojuego videojuegoBuscado = listaVideojuegos.obtener(posicion);

            mostrarDatosVideojuego(videojuegoBuscado);

        } else if (opcionBusqueda == 2) {

            StdOut.print("\nIngrese el nombre del videojuego: ");
            String nombre = StdIn.readString();

            int posicion = listaVideojuegos.buscarVideojuego(nombre);

            Videojuego videojuegoBuscado = listaVideojuegos.obtener(posicion);

            mostrarDatosVideojuego(videojuegoBuscado);

        } else {

            StdOut.println("\nLa opción " + opcionBusqueda + ", no es una opcion del menú");

        }
    }


}
