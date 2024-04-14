package Programa;

import ucn.*;

public class Main {
    public static void main(String[] args) {

       menu();

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


}
