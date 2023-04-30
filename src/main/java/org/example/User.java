package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User {

    boolean alive;
    ArrayList<Ship> Barcos = new ArrayList<Ship>();
    int numeroBarcosIniciales;
    Scanner teclado = new Scanner(System.in);
    int filas, columnas;
    public int [][] tablero = new int[filas][columnas];

    public static final int canoa = 1;
    public static final int fragata = 3;
    public static final int portaaviones = 5;

    public User(boolean alive, int numeroBarcosIniciales, int filas, int columnas) {
        this.alive = alive;
        this.numeroBarcosIniciales = numeroBarcosIniciales;
        this.filas = filas;
        this.columnas = columnas;
    }

    public void crearTablero(){
        int capacidad = teclado.nextInt();
        tablero = new int[capacidad][capacidad];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = 0;
            }
        }
    }
    public void mostrarTablero(){
        System.out.println("---------------------------------");
        for (int[] ints : tablero) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    public void crearBarco(){
        for (int i = 0; i< 3 ; i++){
            System.out.println("Elija el tipo de barco que quiere colocar");
            int opcion;
            System.out.println("1. Portaaviones (5 casillas)");
            System.out.println("2. Fragata (3 casillas)");
            System.out.println("3. Canoa (1 casillas)");
            opcion = teclado.nextInt();

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Has elegido el portaaviones");
                        System.out.println("Introduce la coordenada X");
                        int x = teclado.nextInt();
                        System.out.println("Introduce la coordenada Y");
                        int y = teclado.nextInt();
                        System.out.println("Introduce la direccion en la que quieres colocar el barco (SOUTH, NORTH, EAST, WEST)");
                        CardinalPoints direccionP = CardinalPoints.valueOf(teclado.next().toUpperCase());
                        System.out.println("El barco esta en la posicion -> " + "x: " + x + " y: " + y + " en la direccion:" + direccionP);
                        Barcos.add(new battleship(5, direccionP, 0, false, x, y, 5, 1));
                    }
                    case 2 -> {
                        System.out.println("Has elegido el fragata");
                        System.out.println("Introduce la coordenada X");
                        int x1 = teclado.nextInt();
                        System.out.println("Introduce la coordenada Y");
                        int y1 = teclado.nextInt();
                        System.out.println("Introduce la direccion en la que quieres colocar el barco (SOUTH, NORTH, EAST, WEST)");
                        CardinalPoints direccionF = CardinalPoints.valueOf(teclado.next().toUpperCase());
                        System.out.println("El barco esta en la posicion -> " + "x: " + x1 + " y: " + y1 + " en la direccion:" + direccionF);
                        Barcos.add(new Frigate(3, direccionF, 0, false, x1, y1, 3, 1));
                    }
                    case 3 -> {
                        System.out.println("Has elegido el canoa");
                        System.out.println("Introduce la coordenada X");
                        int x2 = teclado.nextInt();
                        System.out.println("Introduce la coordenada Y");
                        int y2 = teclado.nextInt();
                        System.out.println("El barco esta en la posicion -> " + "x: " + x2 + " y: " + y2);
                        Barcos.add(new Canoe(1, CardinalPoints.NORTH, 0, false, x2, y2, 1, 1));
                    }
                    default -> System.out.println("Debe ingresar un numero entre el 1 y 7");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Debes ingresar un numero.");
                crearBarco();
            }
        }
    }

    public void colocarBarcos() {
        for (Ship barco : Barcos) {
            if (barco instanceof battleship) {
                battleship portaaviones = (battleship) barco;
                if (portaaviones.getDirection() == CardinalPoints.NORTH) {
                    for (int i = 0; i < 5; i++) {
                        tablero[portaaviones.getCoordenadaX()][portaaviones.getCoordenadaY() + i] = 5;
                    }
                } else if (portaaviones.getDirection() == CardinalPoints.SOUTH) {
                    for (int i = 0; i < 5; i++) {
                        tablero[portaaviones.getCoordenadaX()][portaaviones.getCoordenadaY() - i] = 5;
                    }
                } else if (portaaviones.getDirection() == CardinalPoints.EAST) {
                    for (int i = 0; i < 5; i++) {
                        tablero[portaaviones.getCoordenadaX() + i][portaaviones.getCoordenadaY()] = 5;
                    }
                } else if (portaaviones.getDirection() == CardinalPoints.WEST) {
                    for (int i = 0; i < 5; i++) {
                        tablero[portaaviones.getCoordenadaX() - i][portaaviones.getCoordenadaY()] = 5;
                    }
                }
            } else if (barco instanceof Frigate) {
                Frigate fragata = (Frigate) barco;
                if (fragata.getDirection() == CardinalPoints.NORTH) {
                    for (int i = 0; i < 3; i++) {
                        tablero[fragata.getCoordenadaX()][fragata.getCoordenadaY() + i] = 3;
                    }
                } else if (fragata.getDirection() == CardinalPoints.SOUTH) {
                    for (int i = 0; i < 3; i++) {
                        tablero[fragata.getCoordenadaX()][fragata.getCoordenadaY() - i] = 3;
                    }
                } else if (fragata.getDirection() == CardinalPoints.EAST) {
                    for (int i = 0; i < 3; i++) {
                        tablero[fragata.getCoordenadaX() + i][fragata.getCoordenadaY()] = 3;
                    }
                } else if (fragata.getDirection() == CardinalPoints.WEST) {
                    for (int i = 0; i < 3; i++) {
                        tablero[fragata.getCoordenadaX() - i][fragata.getCoordenadaY()] = 3;
                    }
                }
            } else if (barco instanceof Canoe) {
                Canoe canoa = (Canoe) barco;
                tablero[canoa.getCoordenadaX()][canoa.getCoordenadaY()] = 1;
            }
        }
    }

    public boolean attack(Point shot_point, User user) throws Exception {
        boolean acierto = false;
        try {
            for (Ship ship : user.getBarcos()) {
                if (ship instanceof Canoe) {
                    if (tablero[shot_point.getX()][shot_point.getY()] == canoa){
                        acierto = true;
                        ship.get_shot2(shot_point);
                        ship.is_sunk();
                        break;
                    } else {
                        acierto = false;
                    }
                } else if (ship instanceof Frigate) {
                    if (tablero[shot_point.getX()][shot_point.getY()] == fragata){
                        acierto = true;
                        ship.get_shot2(shot_point);
                        ship.is_sunk();
                        break;
                    } else {
                        acierto = false;
                    }
                } else if (ship instanceof battleship) {
                    if (tablero[shot_point.getX()][shot_point.getY()] == portaaviones){
                        acierto = true;
                        ship.get_shot2(shot_point);
                        ship.is_sunk();
                        break;
                    } else {
                        acierto = false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Elije un punto de disparo disponible.");
        }
        return acierto;
    }

    public ArrayList<Ship> getBarcos() {
        return Barcos;
    }

    public void setBarcos(ArrayList<Ship> barcos) {
        Barcos = barcos;
    }

    public void is_alive() {
        if (alive == true) {
            System.out.println("El jugador esta vivo");
        }
    }
    public void die(){
        if(!alive){
            System.out.println("El jugador ha muerto");
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumeroBarcosIniciales() {
        return numeroBarcosIniciales;
    }

    public void setNumeroBarcosIniciales(int numeroBarcosIniciales) {
        this.numeroBarcosIniciales = numeroBarcosIniciales;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
}