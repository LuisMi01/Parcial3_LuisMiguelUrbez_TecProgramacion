package org.example;

import java.util.Scanner;

public class Ship {
    private int size;
    private int hits;
    private Point startPoint;
    private Point endPoint;
    private CardinalPoints direction;

    public Ship() {
        // Constructor sin argumentos
    }

    public Ship(int size, Point startPoint, Point endPoint, CardinalPoints direction) {
        if (!isValidShip(size, startPoint, endPoint)) {
            throw new IllegalArgumentException("Invalid ship parameters");
        }
        this.size = size;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.direction = direction;
        this.hits = 0;
    }

    public boolean isSunk() {
        return hits == size;
    }

    public boolean getShot(Point shotPoint) {
        if (isHit(shotPoint)) {
            hits++;
            return true;
        }
        return false;
    }

    private boolean isHit(Point shotPoint) {
        int x1 = startPoint.getX();
        int y1 = startPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();
        int x = shotPoint.getX();
        int y = shotPoint.getY();
        return ((x == x1 && y >= y1 && y <= y2) || (y == y1 && x >= x1 && x <= x2));
    }

    private boolean isValidShip(int size, Point startPoint, Point endPoint) {
        if (startPoint.equals(endPoint)) {
            return false;
        }
        if (size < 1 || size > 5) {
            return false;
        }
        int x1 = startPoint.getX();
        int y1 = startPoint.getY();
        int x2 = endPoint.getX();
        int y2 = endPoint.getY();
        if (x1 != x2 && y1 != y2) {
            return false;
        }
        if (x1 > x2 || y1 > y2) {
            return false;
        }
        int length = Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)) + 1;
        return size == length;
    }

    public void setDirection(CardinalPoints direction) {
        this.direction = direction;
    }

    // getters and setters
    public CardinalPoints getDirection() {
        return direction;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}


    /*public void get_shot2(Point shot_point) {
        try {
            if (attack(shot_point, this) == true) {
                User.tablero[shot_point.getX()][shot_point.getY()] = 'x';
                System.out.println("¡Han acertado en un barco!");
            } else if (attack(shot_point, this) == 2) {
                System.out.println("¡Fallaste!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

