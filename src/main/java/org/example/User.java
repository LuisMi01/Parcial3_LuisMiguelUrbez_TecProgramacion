package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class User {

    Scanner teclado = new Scanner(System.in);
    boolean alive;
    ArrayList<Ship> Ships = new ArrayList<Ship>();
    int filas, columnas;
    public int [][] tablero = new int[filas][columnas];
    public static final String canoa = "C";
    public static final String fragata = "F";
    public static final String portaaviones = "P";
    CardinalPoints CardinalPoints;


    public User(Ship[] ships) throws IllegalArgumentException {
        if (ships == null || ships.length == 0) {
            throw new IllegalArgumentException("Debe haber al menos un barco en la lista.");
        }
        for (Ship ship : ships) {
            if (ship == null) {
                throw new IllegalArgumentException("La lista de barcos no puede contener valores nulos.");
            }
        }
        this.Ships = new ArrayList<>(Arrays.asList(ships));
        this.alive = true;
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

    public void crearBarcos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Se van a crear los baros del jugador (maximo 3 barcos)");
        for (int i = 0; i < 2; i++) {
            System.out.println("Selecione uno de los barcos disponibles:");
            System.out.println("1. Canoa");
            System.out.println("2. Fragata");
            System.out.println("3. Portaaviones");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la posicion inicial de la canoa");
                    System.out.println("Ingrese la fila");
                    int x = teclado.nextInt();
                    System.out.println("Ingrese la columna");
                    int y = teclado.nextInt();
                    System.out.println("El barco esta en la posicion -> " + "x: " + x + " y: " + y);
                    Point puntoInicial = new Point(x, y);
                    Ships.add(new Canoe(puntoInicial, CardinalPoints.NORTH));
                    break;

                case 2:
                    System.out.println("Ingrese la posicion inicial de la fragata");
                    System.out.println("Ingrese la fila");
                    int x1 = teclado.nextInt();
                    System.out.println("Ingrese la columna");
                    int y1 = teclado.nextInt();
                    System.out.println("Introduce la direccion en la que quieres colocar el barco (SOUTH, NORTH, EAST, WEST)");
                    CardinalPoints direccionF = CardinalPoints.valueOf(teclado.next().toUpperCase());
                    System.out.println("El barco esta en la posicion -> " + "x: " + x1 + " y: " + y1 + " en la direccion:" + direccionF);
                    Point puntoInicialF = new Point(x1, y1);
                    Ships.add(new Frigate(puntoInicialF, direccionF));
                    break;

                case 3:
                    System.out.println("Ingrese la posicion inicial del portaaviones");
                    System.out.println("Ingrese la fila");
                    int x2 = teclado.nextInt();
                    System.out.println("Ingrese la columna");
                    int y2 = teclado.nextInt();
                    System.out.println("Introduce la direccion en la que quieres colocar el barco (SOUTH, NORTH, EAST, WEST)");
                    CardinalPoints direccionP = CardinalPoints.valueOf(teclado.next().toUpperCase());
                    System.out.println("El barco esta en la posicion -> " + "x: " + x2 + " y: " + y2 + " en la direccion:" + direccionP);
                    Point puntoInicialP = new Point(x2, y2);
                    Ships.add(new Battleship(puntoInicialP, calculateEndPoint(puntoInicialP, 5, direccionP),direccionP));
                    break;
            }
        }
    }

    public Point calculateEndPoint(Point startPoint, int length, CardinalPoints direction) {
        int x = startPoint.getX() + length - 1;
        int y = startPoint.getY();

        switch (direction) {
            case NORTH:
                x = startPoint.getX();
                y = startPoint.getY() - length + 1;
                break;
            case SOUTH:
                x = startPoint.getX();
                y = startPoint.getY() + length - 1;
                break;
            case EAST:
                x = startPoint.getX() + length - 1;
                y = startPoint.getY();
                break;
            case WEST:
                x = startPoint.getX() - length + 1;
                y = startPoint.getY();
                break;
        }
        return new Point(x, y);
    }
    

    public void colocarBarcos() {


    }

    public boolean attack(Point shot_point, User user) {

    }


    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public ArrayList<Ship> getShips() {
        return Ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        Ships = ships;
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