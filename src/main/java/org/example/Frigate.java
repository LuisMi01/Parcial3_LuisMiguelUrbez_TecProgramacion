package org.example;

import java.util.ArrayList;

public class Frigate extends Ship {

    public static final int size = 5;

    public Frigate(Point startPoint, Point endPoint, CardinalPoints direction) {
        super(size, startPoint, endPoint, direction);
    }

    @Override
    public String toString() {
        return "Portaaviones, size: " + size + ", start point: " + startPoint.toString() + ", end point: " + endPoint.toString() + ", direction: " + direction.toString();
    }
}
