package org.example;
import java.util.Scanner;


public class Menu {

    public void menu() {

        Scanner scanner = new Scanner(System.in);

            System.out.println("CREACIÓN DEL JUGADOR");
            System.out.println("Ingrese su nombre:");
        String nombreJugador = scanner.nextLine();
            System.out.println("Ingrese el número de filas del tablero:");
        int filasTablero = scanner.nextInt();
            System.out.println("Ingrese el número de columnas del tablero:");
        int columnasTablero = scanner.nextInt();

        User jugador = new User(true, filasTablero, columnasTablero);


            System.out.println("Se va a proceder a colocar los barcos en el tablero");
            jugador.crearBarcos();
            jugador.colocarBarcosTablero();
            jugador.mostrarTablero();

            System.out.println("\nCREACIÓN DEL ENEMIGO");
            System.out.println("Ingrese su nombre:");
        String nombreEnemigo = scanner.nextLine();

        User enemigo = new User(true, filasTablero, columnasTablero);

            System.out.println("Se va a proceder a colocar los barcos del enemigo en el tablero");
            enemigo.crearBarcos();
            enemigo.colocarBarcosTablero();
            enemigo.mostrarTablero();


        // Comenzar el juego
            System.out.println("\n¡Que comience el juego!");

        boolean jugadorGanador = false;
        boolean enemigoGanador = false;

            while(!jugadorGanador &&!enemigoGanador)

        {

            System.out.println("\n" + nombreJugador + ", es su turno:");
            System.out.println("Ingrese la coordenada X del disparo:");
            int x = scanner.nextInt();
            System.out.println("Ingrese la coordenada Y del disparo:");
            int y = scanner.nextInt();
            Point coordenadasDisparoJugador = new Point(x, y);
            jugador.attack(coordenadasDisparoJugador, jugador);
            if (jugador.checkAllShipsSunk()) {
                jugadorGanador = true;
            }

            // Turno del enemigo
            System.out.println("\nTurno del enemigo:");
            System.out.println("Ingrese la coordenada X del disparo:");
            int x1 = scanner.nextInt();
            System.out.println("Ingrese la coordenada Y del disparo:");
            int y1 = scanner.nextInt();
            Point coordenadasDisparoEnemigo = new Point(x1, y1);
            enemigo.attack(coordenadasDisparoEnemigo, enemigo);
            if (enemigo.checkAllShipsSunk()) {
                enemigoGanador = true;
            }

        }

    }
}


