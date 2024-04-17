package Programa;

import ucn.*;

public class Main {
    public static void main(String[] args) {

        ListaEmpleados listaEmpleados = new ListaEmpleados(5);

        listaEmpleados.lecturaArchivo("Trabajadores.txt");

        //prueba para comprobar que la lectura se realizó con éxito
        mostrarEmpleados(listaEmpleados);

        ListaVideojuegos listaVideojuegos = new ListaVideojuegos(10);

        listaVideojuegos.lecturaArchivo("Juegos.txt");

        //prueba para comprobar que la lectura se realizó con éxito
        mostrarVideojuegos(listaVideojuegos);

        //menu();

    }


    public static void menu() {

        String CONTINUAR = "";


        boolean menuActivado = true;

        while (menuActivado != false) {

            StdOut.println("""
                    **************************************************
                    * Bienvenido al Sistema de Ventas de Videojuegos *
                    **************************************************
                    Identifícate:
                    [1] Iniciar Sesión
                    [2] Cerrar Programa""");

            StdOut.print("\nElija una opción: ");
            int opcion = validarOpcion();


            switch (opcion){


                case 1 -> {

                    StdOut.println("\nIniciar Sesión");

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





}
