package Programa;

import ucn.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        /***************************
         *
         * @Autores: Rodrigo Aguilera y Diego Cortés
         *
         * Este programa está basado en una tienda sobre videojuego llamada GameTech, la cuál, le solicitó
         *  a los estudiantes de Programación Avanzada de la UCN, crear un programa que los ayude a mejorar
         *  la experiencia de compra de sus clientes.
         *
         * Este programa utiliza diversas clases para manejar los datos, ya sea, de los empleados que comtrolan
         *  el programa, los videojuegos que posee la propia tienda, como también, los clientes y/o miembros
         *  acuales o potenciales de ésta misma.
         *
         ***************************/

        menu();

    }


    /**
     *
     * Función que se encarga de manejar el menú completo del programa.
     *
     */
    public static void menu() throws IOException {

        // variable para acumular el monto total de las ventas
        int montoTotal = 0;


        //Se crean las listas de los empleados, videojuegos, clientes; llamando a las  clases (Listas)

        ListaEmpleados listaEmpleados = new ListaEmpleados(999);
        ListaVideojuegos listaVideojuegos = new ListaVideojuegos(999);
        ListaCliente listaClientes = new ListaCliente(999);


        //Se utilizan los metodos en estas listas para realizar la lectura de archivo para cada una
        listaEmpleados.LecturaArchivo();
        listaVideojuegos.LecturaArchivo();


        // se crea un menu para el inicio de sesion de los empleados
        boolean menuinicial = false;

        String generoOferta = listaVideojuegos.generoEnOferta();


        while (!menuinicial) {


            StdOut.println("\n**** [Bienvenido al sistema de ventas] ****");
            StdOut.println("Por favor, Identifique su identidad");
            StdOut.println("*******************************************");
            StdOut.println("ingrese una opcion para continuar:");
            StdOut.println("[1] Iniciar Sesion ");
            StdOut.println("[2] Cerrar programa");

            StdOut.print("\nOpcion: ");
            String opcion = StdIn.readString();

            switch (opcion) {

                case "1" -> {

                    //se busca si existe el empleado en la lista.
                    int empleadoInicioSesion = iniciarSesion(listaEmpleados);


                    // si existe el empleado en la lista, se accede al if para continuar con las operaciones
                    if (empleadoInicioSesion != -1){

                        StdOut.println("\nSe ha iniciado sesion");
                        StdOut.println("");

                        //se llama al metodo menu principal, para realizar las demás acciones del sistema..
                        MenuPrincipal(listaEmpleados,listaVideojuegos,listaClientes,empleadoInicioSesion,generoOferta);

                    }

                    // si no se logra iniciar sesion, se vuelve al menu de inicio de sesion..

                    else {

                        StdOut.println("");
                        StdOut.println("Error al iniciar sesion, volviendo al menu..");

                        StdOut.println("Ingrese enter para continuar");
                        String enter = StdIn.readString();
                        StdOut.println("");

                    }

                }

                // Opcion para cerrar el programa.

                case "2" -> {

                    StdOut.println("Cerrando Programa ʕ•́ᴥ•̀ʔっ♡");
                    menuinicial = true;

                }

                // Opcion de excepcion para el ingreso de terminos no deseados.

                default -> {

                    StdOut.println("el término " + opcion + " no es un número entero, ingrese nuevamente");

                }

            }

        }

    }


    /**
     *
     * Función para inicializar el programa, iniciando sesión por teclado con la respectiva
     *  cuenta de los empleados.
     * Se verifica si existe y si cumplen las condiciones para iniciar sesión.
     *
     *@param listaEmpleados
     *@return Devuelve un int, con la posicion en que se encuentra el empleado dentro de la lista.
     */
    public static int iniciarSesion(ListaEmpleados listaEmpleados) {

        int posicion;

        boolean condiciones = false;

        Empleado empleadoBuscar = null;

        StdOut.print("\nIngrese su nombre de usuario: ");
        String nombre = StdIn.readString();

        StdOut.print("\nIngrese su contraseña (si contiene una 'ñ', reemplácela por una 'n') : ");
        String contrasenia = StdIn.readString();


        //se busca al empleado usando la funcion de la lista empleado, buscar por su nombre y se identifica, si existe, su posicion.
        int posicionEmpleado = listaEmpleados.buscarEmpleado(nombre);

        //si no existe, la posicion encontrada será -1, por lo que el subprograma termina aqui.
        if (posicionEmpleado == -1) {
            return -1;
        }

        //si el empleado encontrado existe, se busca en la lista empleado para guardar sus datos.
        empleadoBuscar = listaEmpleados.getListaEmpleados()[posicionEmpleado];


        // se compara los datos ingresados por teclado con los datos que se encontraron en la instancia empleado anterior
        // si los términos son iguales, (el nombre usuario y contraseña) se permite iniciar sesión y se retorna al posición.

        if (empleadoBuscar.getContrasenia().equalsIgnoreCase(contrasenia) && empleadoBuscar.getNombreUsuario().equalsIgnoreCase(nombre) || contrasenia.contains("ñ")) {

            condiciones = true;

        }

        //si el nombre de usuario y contraseña no coinciden, se devuelve un -1, el ingreso ha sido incorrecto.
        else {
            return -1;
        }

        //si las condiciones se cumplen, se retorna la posicion.
        if(condiciones == true) {
            return posicionEmpleado;
        }

        return posicionEmpleado;

    }


    /**
     *
     * Menú principal, recibe por parametros todas las listas y la posición del empleado que ha iniciado sesión.
     * Se realizan las operaciones de vender videojuego, buscar videojuego y estadísticas.
     *
     * @param listaEmpleados
     * @param listaVideojuegos
     * @param listaCliente
     * @param posicionEmpleado
     * @param generoOferta
     */
    public static void MenuPrincipal(ListaEmpleados listaEmpleados, ListaVideojuegos listaVideojuegos, ListaCliente listaCliente, int posicionEmpleado, String generoOferta) {

        boolean menu = false;

        while (menu != true) {

            StdOut.println("El genero en oferta es : "+generoOferta+"!!");

            StdOut.println("******************************");
            StdOut.println("      [Menu Principal]");
            StdOut.println("******************************");

            StdOut.println("Ingrese una opcion: ");
            StdOut.println("[1] Vender videojuego");
            StdOut.println("[2] Buscar videojuego");
            StdOut.println("[3] Menú estadisticas");
            StdOut.println("[4] Salir");

            StdOut.print("\nOpcion: ");
            String opcion = StdIn.readString();

            switch (opcion) {

                case "1" -> {

                    venderVideojuego(listaVideojuegos,listaEmpleados,listaCliente,generoOferta,posicionEmpleado);

                }

                case "2" -> {

                    buscarVideojuego(listaVideojuegos);

                }

                case "3" -> {

                  menuEstadisticas(listaVideojuegos,listaEmpleados,listaCliente);

                }

                case "4" -> {

                    StdOut.println("\nCerrando menu..");
                    StdOut.println("");
                    menu = true;

                }

                //excepciones
                default -> {

                    StdOut.println("\ntermino ingresado incorrecto..");

                }

            }

        }

    }


    /**
     *
     *  Menu para las estadisticas, se realizan las operaciones de las estadisticas y se muestran por pantalla.
     *
     * @param listaEmpleados
     * @param listaVideojuegos
     * @param listaCliente
     */
    private static void menuEstadisticas(ListaVideojuegos listaVideojuegos, ListaEmpleados listaEmpleados, ListaCliente listaCliente) {

        boolean menu = false ;

        while (!menu) {

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

            String texto = "\nIngrese una opcion: ";
            int opcion = verificarNumero(texto);


            if (opcion == 1) {

                StdOut.println("********************************************************************");
                StdOut.println("Estadistica: videojuego con mayor cantidad de ventas: ");


                int cantidadMaximaVendida = listaVideojuegos.buscarCantidadMaximaVendida();

                if ( cantidadMaximaVendida == 0) {
                    StdOut.println("\nNo se registra ningun videojuego que sea el mas vendido");
                }

                else {

                    for (int i = 0; i < listaVideojuegos.getCantidadActual(); i++) {

                        if (listaVideojuegos.getListaVideojuegos()[i].getCantidadVentas() == cantidadMaximaVendida) {

                            StdOut.println(listaVideojuegos.empaquetarVideojuego(i));

                        }

                    }

                }

            }


            if (opcion == 2) {

                String plataformaventas;
                int cantidadVentasPlataformas = 0;

                boolean existeUnaCantidadMayor = true;

                if (listaVideojuegos.getCantidadXbox() > listaVideojuegos.getCantidadNintendo()
                        && listaVideojuegos.getCantidadXbox() > listaVideojuegos.getCantidadPlaystation()) {

                    plataformaventas = "Xbox";
                    cantidadVentasPlataformas = listaVideojuegos.getCantidadXbox();

                }
                else if (listaVideojuegos.getCantidadPlaystation() > listaVideojuegos.getCantidadNintendo()
                        && listaVideojuegos.getCantidadPlaystation() > listaVideojuegos.getCantidadXbox()) {

                    plataformaventas = "Playstation";
                    cantidadVentasPlataformas = listaVideojuegos.getCantidadPlaystation();

                }

                else if (listaVideojuegos.getCantidadNintendo() > listaVideojuegos.getCantidadPlaystation()
                        && listaVideojuegos.getCantidadNintendo() > listaVideojuegos.getCantidadXbox()) {

                    plataformaventas = "Nintendo";
                    cantidadVentasPlataformas = listaVideojuegos.getCantidadNintendo();

                }
                else {

                   plataformaventas = "\nExisten 2 o mas plataformas con la misma cantidad de ventas.";
                   existeUnaCantidadMayor = false;

                }


                if (existeUnaCantidadMayor != false) {

                   StdOut.println("********************************************************************");
                   StdOut.println("\nEstadistica: plataforma con mayor cantidad de ventas: ");
                   StdOut.println("\n"+ plataformaventas);
                   StdOut.println("Con una cantidad de: "+cantidadVentasPlataformas);
                   StdOut.println("********************************************************************");

                }

                else {
                   StdOut.println(plataformaventas);
                }

            }


            if (opcion == 3) {

                StdOut.println("********************************************************************");
                StdOut.println("Estadistica: ventas realizadas a clientes miembros ");
                StdOut.println("\nCantidad de compras realizadas a miembros: "+listaCliente.getCantidadVentas());
                StdOut.println("Monto total de las ventas realizadas a miembros: "+listaCliente.getMontoTotalVentas());
                StdOut.println("********************************************************************");

            }


            if (opcion == 4) {

                StdOut.println("********************************************************************");
                StdOut.println("Estadistica: dinero total recaudado ");
                StdOut.println("\nEl monto total es: "+listaVideojuegos.montoTotal()+"$");
                StdOut.println("********************************************************************");

            }


            if (opcion == 5) {

                int posicionEmpleadoMayorVentas = listaEmpleados.buscarEmpleadoMasVentas();

                if (posicionEmpleadoMayorVentas == -1) {

                   StdOut.println("No existe un empleado con la mayor cantidad de ventas");

                }

                else {

                   Empleado empleadoInstancia = listaEmpleados.getListaEmpleados()[posicionEmpleadoMayorVentas];

                   StdOut.println("********************************************************************");
                   StdOut.println("\n*** Estadistica : empleado con mayor ventas ***");
                   StdOut.println("\nNickname: "+empleadoInstancia.getNombreUsuario()+ "\n Cantidad de ventas: "+empleadoInstancia.getCantidadVentas()+" \nDinero ganado: "+empleadoInstancia.getComicion());
                   StdOut.println("********************************************************************");

                }

            }


            if (opcion == 6) {

                StdOut.println("\nVolviendo al menu anterior..");
                menu = true;

            }


            StdOut.println("[Ingrese enter para continuar]");
            String enter = StdIn.readString();

        }

    }


    /**
     *
     * Función para buscar un videojuego, ya sea, por código, como por nombre.
     * Al encontrarse, se despliego toda su información por pantalla.
     *
     * @param listaVideojuegos
     */
    private static void buscarVideojuego(ListaVideojuegos listaVideojuegos) {


        int posicionJuego;

        boolean buscarvideojuegoMenu = false;
        String opcion;

        while (buscarvideojuegoMenu != true) {

            StdOut.println("\neliga una opcion para buscar el videojuego!!");
            StdOut.println("[1] Codigo unico");
            StdOut.println("[2] Nombre Videojuego");

            opcion = StdIn.readString();

            switch (opcion) {


                case "1" -> {

                    String frase ="\nIngrese el codigo unico del videojuego (numero entero, ejemplo 1): ";
                    int numeroCodigoUnico = verificarNumero(frase);

                     posicionJuego = listaVideojuegos.buscarVideojuego(numeroCodigoUnico);

                    if (posicionJuego == -1) {

                        StdOut.println("\nel videojuego no se ha encontrado en la lista");

                    }

                    else {

                        StdOut.println("\n***El videojuego encontrado es: ***");
                        StdOut.println(listaVideojuegos.empaquetarVideojuego(posicionJuego));

                    }



                    buscarvideojuegoMenu = true;

                }

                case "2" -> {

                    StdOut.print("\nIngrese el nombre del videojuego: ");
                    String nombreVideojuegoAbuscar = StdIn.readString();

                    posicionJuego = listaVideojuegos.buscarVideojuego(nombreVideojuegoAbuscar);

                    if (posicionJuego == -1) {

                        StdOut.println("\nel videojuego no se ha encontrado en la lista");

                    }

                    else {

                        StdOut.println("\n***El videojuego encontrado es: ***");
                        StdOut.println(listaVideojuegos.empaquetarVideojuego(posicionJuego));

                    }


                    buscarvideojuegoMenu = true;

                }

                default -> {

                    StdOut.println("\nEstimado usuario, el termino "+opcion+ " no es valido, ingrese nuevamente");

                }

            }

        }

        StdOut.println("\nIngrese enter para continuar");
        String enter = StdIn.readLine();

    }


    /**
     * Función para vender videojuegos, se verifica que se realice una venta, que el usuario sea miembro o no,
     *  el descuento del videojuego y el precio de venta del videojuego.
     *
     * @param listaEmpleados
     * @param listaVideojuegos
     * @param listaCliente
     * @param generoOferta
     * @param posicionEmpleado
     * @return Devuelve boolean, true si la venta se realizó con éxito, y false, si no lo hizo.
     */
    public static boolean venderVideojuego(ListaVideojuegos listaVideojuegos, ListaEmpleados listaEmpleados, ListaCliente listaCliente, String generoOferta, int posicionEmpleado) {

        boolean miembro = false;

        StdOut.print("\nIngrese el nombre del videojuego: ");
        String nombreVideojuego = StdIn.readString();

        int posicion = listaVideojuegos.buscarVideojuego(nombreVideojuego);

        if (posicion == -1) {

            StdOut.println("\nEl videojuego no se encuentra en el registro :( \n");
            return false;

        }


        Videojuego videojuegoBuscado = listaVideojuegos.getListaVideojuegos()[posicion];

        boolean menuCliente = false;

        while (menuCliente !=true) {

            StdOut.println("\nEl cliente posee una cuenta miembro de GameTech?");
            StdOut.println("[1] SI");
            StdOut.println("[2] NO");

            String opcion = StdIn.readString();

            switch (opcion) {

                case "1" -> {

                    StdOut.print("\nIngrese su rut: ");
                    String rut = StdIn.readString();

                    int posicionMiembro = listaCliente.buscarCliente(rut);

                    if (posicionMiembro == -1) {

                        StdOut.println("\nNo existe un miembro con ese rut!");
                        StdOut.println("");
                        StdOut.println("ingrese enter para continuar: ");

                        String enter = StdIn.readLine();

                        return false;

                    }

                    menuCliente = true;
                    miembro = true;

                }

                case "2" -> {

                    boolean opcionValida = false;
                    while (opcionValida != true) {

                        StdOut.println("\nExisten descuentos exclusivos por ser miembro!! ");

                        StdOut.println("\nDesea ser miembro?");

                        StdOut.println("[1] SI");
                        StdOut.println("[2] NO");

                        String opcionMiembro = StdIn.readString();

                        switch (opcionMiembro) {

                            case "1" -> {

                             StdOut.println("\ningrese su rut");
                             String rut = StdIn.readString();

                             StdOut.println("\nIngrese su nombre completo");
                             String nombre = StdIn.readString();

                             StdOut.println("\nIngrese un correo: ");
                             String correo = StdIn.readString();

                             Cliente nuevoCliente = new Cliente(rut,nombre,correo);

                             if (listaCliente.AgregarCliente(nuevoCliente)) {

                                 miembro = true;
                                 opcionValida = true;
                                 menuCliente = true;

                             }

                             else {

                                 StdOut.println("\nya existe un cliente con este rut!!");

                             }

                            }

                            case "2" -> {

                             StdOut.println("\n**Continue con la compra..**\n");
                             opcionValida = true;
                             menuCliente = true;

                            }

                            default -> {

                             StdOut.println("\ningrese un termino correcto..");

                            }

                        }

                    }

                }

                default -> {

                    StdOut.println("\nEl termino ingresado no es valido, ingrese nuevamente... \n");

                }

            }

        }


        int precio = videojuegoBuscado.getPrecio();


        if (miembro == true) {

            StdOut.println("\nPor ser miembro existe un descuento del 30%!!");
            StdOut.println("");

            StdOut.println("\nEl genero con descuento es: ");

            StdOut.println("***"+generoOferta + "***");

            StdOut.println("El genero del juego a comprar es: ");
            StdOut.println("***"+listaVideojuegos.getListaVideojuegos()[posicion].getGenero()+"***");

            StdOut.println("");

            if (videojuegoBuscado.getGenero().equalsIgnoreCase(generoOferta)) {

                precio = (int) (videojuegoBuscado.getPrecio()*0.70);

                StdOut.println("\nSe aplica el descuento..");
                StdOut.println("Precio original : "+listaVideojuegos.getListaVideojuegos()[posicion].getPrecio()+"$");
                StdOut.println("Nuevo precio: "+precio+"$");

            }

            else {
                StdOut.println("\nEl genero del videojuego no corresponde al genero con descuento :(");
            }

        }


        boolean menuCompra = false;

        while (menuCompra != true) {

            StdOut.println("Finalizar la compra de: "+nombreVideojuego +" Por el precio de: "+precio+"$");
            StdOut.println("[1] Realizar compra");
            StdOut.println("[2] Cancelar");

            String opcion = StdIn.readString();

            switch (opcion) {

                case "1"-> {

                    Empleado empleadoComicion = listaEmpleados.getListaEmpleados()[posicionEmpleado];

                    StdOut.println("Compra realizada!");


                    //Realizar estadisticas:
                    int comicion = (int) (empleadoComicion.getComicion()+(precio*0.02));
                    int cantidadVentas = empleadoComicion.getCantidadVentas()+1;


                    // el empleado que ha iniciado sesion recibe la comision por la venta, y su cantidad de ventas aumenta
                    empleadoComicion.setComicion(comicion);
                    empleadoComicion.setCantidadVentas(cantidadVentas);

                    //se registra que videojuego se vendio, y el monto total al que se vendio
                    videojuegoBuscado.setMontototal((videojuegoBuscado.getMontototal()+precio));
                    videojuegoBuscado.setCantidadVentas((videojuegoBuscado.getCantidadVentas()+1));


                    //contador segun la plataforma del videojuego comprado

                    if (videojuegoBuscado.getPlataforma().equalsIgnoreCase("Nintedo")) {

                       listaVideojuegos.setCantidadNintendo((listaVideojuegos.getCantidadNintendo()+1));

                    }
                    else if (videojuegoBuscado.getPlataforma().equalsIgnoreCase("Playstation")) {

                       listaVideojuegos.setCantidadPlaystation((listaVideojuegos.getCantidadPlaystation()+1));

                    }
                    else if (videojuegoBuscado.getPlataforma().equalsIgnoreCase("Xbox")) {

                       listaVideojuegos.setCantidadXbox((listaVideojuegos.getCantidadXbox()+1));

                    }
                    else if (videojuegoBuscado.getPlataforma().equalsIgnoreCase("multiplataforma")) {

                       listaVideojuegos.setCantidadNintendo((listaVideojuegos.getCantidadNintendo()+1));
                       listaVideojuegos.setCantidadPlaystation((listaVideojuegos.getCantidadPlaystation()+1));
                       listaVideojuegos.setCantidadXbox((listaVideojuegos.getCantidadXbox()+1));

                    }


                    if (miembro == true) {

                       listaCliente.setCantidadVentas(listaCliente.getCantidadVentas()+1);
                       listaCliente.setMontoTotalVentas(listaCliente.getMontoTotalVentas()+precio);

                    }


                    menuCompra = true;

                }

                case "2" -> {

                    StdOut.println("La compra no se ha realizado..");
                    menuCompra =true;

                }

                case "3" -> {

                    StdOut.println("Estimado usuario, el termino "+opcion + "no es valido, intente nuevamente");

                }

            }

        }

        StdOut.println("");
        return true;

    }


    /**
     *
     * Función que verifica que una opción ingresada sea correcta.
     *
     * @return Devuelve un int con el valor de una opción elegida.
     */
    public static int verificarNumero(String frase) {

        int opcion =0;
        boolean verificarnumero = false;


        while (!verificarnumero) {

            StdOut.print(frase);
            String opcionComoString = StdIn.readString();

            try {

                opcion = Integer.parseInt(opcionComoString);
                verificarnumero = true;

            } catch (NumberFormatException exception) {

                StdOut.println("Estimado usuario, ingrese un numero valido..");

            }

        }

        return opcion;

    }


}