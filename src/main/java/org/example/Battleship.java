package org.example;

public class Battleship extends Ship {

    public static final int size = 5;

        public Battleship(Point startPoint, Point endPoint, CardinalPoints direction) {
            super(size, startPoint, endPoint, direction);
        }

    @Override
    public String toString() {
        return "Portaaviones, size: " + size + ", start point: " + startPoint.toString() + ", end point: " + endPoint.toString() + ", direction: " + direction.toString();
    }

}

