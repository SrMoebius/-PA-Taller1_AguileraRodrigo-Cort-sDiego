package Programa;

import ucn.*;

public class Main {
    public static void main(String[] args) {

        StdOut.println("Hola Mundillo de youtube!");
        StdOut.println("UwU");

        StdOut.println("\nPrueba 1");

       menu();
    }


    public static void menu(){

        Boolean menuActivado = true;

        while (!menuActivado != false){


            StdOut.println("***********************************************");
            StdOut.println("Bienvenido al sistema de ventas de videojuegos ");
            StdOut.println("***********************************************");
            StdOut.println("Ingrese una opcion para continuar: ");
            StdOut.println("1) Ingresar Sesion ");
            StdOut.println("2) Cerrar Programa");

            StdOut.print("opcion:");
            String opcion = StdIn.readString();

            switch (opcion){


                case "1" -> {

                }


                case "2"-> {


                }



                default -> {

                    StdOut.println("El termino "+opcion+" no es una opcion valida");
                }

            }
        }
    }
}