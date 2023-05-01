package org.example;

public class Canoe extends Ship {

    public static final int size = 5;

    public Canoe(Point startPoint, Point endPoint, CardinalPoints direction) {
        super(size, startPoint, endPoint, direction);
    }

    @Override
    public String toString() {
        return "Canoa, size: " + size + ", start point: " + startPoint.toString() + ", end point: " + endPoint.toString() + ", direction: " + direction.toString();
    }
}
