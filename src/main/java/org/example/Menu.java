package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner teclado = new Scanner(System.in);
    User jugador1 = new User(true, 3, 1, 1);

    User jugador2 = new User(true, 3, 1, 1);
    public void menu(){
        System.out.println("BIENVENIDO AL JUEGO BATTLESHIP");
        Scanner teclado = new Scanner(System.in);
        System.out.println("""
                Ambos jugadores van a empezar con 3 barcos,
                 cada uno posicionara un tipo de barco en la casilla y direccion que elija
                """);


        System.out.println("Inserte los tamaños de los tableros:");
        System.out.println("Tablero del primer jugador:");
        jugador1.crearTablero();
        System.out.println("Tablero del segundo jugador:");
        jugador2.crearTablero();

        jugador1.mostrarTablero();
        jugador2.mostrarTablero();

        System.out.println("\nSe va a proceder a elijir los barcos para los jugadores:");
        System.out.println("Empezamos por el primer jugarp (Elija sus tres barcos)");
        jugador1.crearBarco();
        System.out.println("\nTurno del segundo jugador (Elija sus tres barcos)");
        jugador2.crearBarco();

        System.out.println("\nSe va a proceder a colocar los barcos y mostrar ambos tableros");

        jugador1.colocarBarcos();
        jugador2.colocarBarcos();

        jugador1.mostrarTablero();
        jugador2.mostrarTablero();

        System.out.println("Una vez mostrados los tableros se va a proceder a jugar\n");

    }
}