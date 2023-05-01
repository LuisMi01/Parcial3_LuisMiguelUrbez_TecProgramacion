package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
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

    public void crearBarco() {
        Scanner scanner = new Scanner(System.in);

        if (Ships.size() < 3) {
            System.out.println("Elija el tipo de barco que desea crear:");
            System.out.println("1 - Battleship");
            System.out.println("2 - Canoe");
            System.out.println("3 - Frigate");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Introduzca la coordenada X:");
            int x = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduzca la coordenada Y:");
            int y = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduzca la dirección en la que desea colocar el barco (NORTH, SOUTH, EAST, WEST):");
            String direccion = scanner.nextLine();

            CardinalPoints direccionP = CardinalPoints.valueOf(direccion.toUpperCase());

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido el portaaviones");
                    System.out.println("Introduce la longitud del barco:");
                    int length = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce la anchura del barco:");
                    int width = scanner.nextInt();
                    scanner.nextLine();
                    Ships.add(new Battleship(new Point(x, y), calculateEndPoint(new Point(x, y), direccionP, 5), direccionP));
                    break;
                case 2:
                    System.out.println("Has elegido la canoa");
                    System.out.println("Introduce la longitud del barco:");
                    int length2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce la anchura del barco:");
                    int width2 = scanner.nextInt();
                    scanner.nextLine();
                    Ships.add(new Canoe(length2, new Point(x, y), direccionP, length2, width2));
                    break;
                case 3:
                    System.out.println("Has elegido la fragata");
                    System.out.println("Introduce la longitud del barco:");
                    int length3 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce la anchura del barco:");
                    int width3 = scanner.nextInt();
                    scanner.nextLine();
                    Ships.add(new Frigate(length3, new Point(x, y), direccionP, length3, width3));
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } else {
            System.out.println("Ya has creado el máximo de barcos permitidos");
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