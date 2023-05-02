package org.example.Ejercicio8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void menu(){
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        System.out.println("Bienvenido a la implementacion de barcos y puertos  usando grafos.");
        System.out.println("Elija una de las opciones");
        do {
            int opcion;
            System.out.println("1.- Añadir puerto (vertice)");
            System.out.println("2.- Añadir camino entre puertos (arista)");
            System.out.println("3.- Calacular camino mas corto entre dos puertos");
            System.out.println("4.- Barrido en profundidad");
            System.out.println("5.- Eliminar el puerto con mayor cantidad de aristas");
            System.out.println("6.- Mostrar el grafo completo");
            System.out.println("4.- Salir \n");

            opcion = teclado.nextInt();

            try {
                switch (opcion) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        break;

                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        salir = true;
                        break;

                    default:
                        System.out.println("Debe ingresar un numero entre el 1 y 6");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Debes ingresar un numero.");
                teclado.next();
                salir = false;
            }

        }while (!salir);

    }
}
