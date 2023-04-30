package org.example;

import java.util.ArrayList;

public class Battleship extends Ship {
    int length = 5;
    int width = 1;

    public Battleship(int size, CardinalPoints direction, int hits, boolean isSunk, int coordenadaX, int coordenadaY, int length, int width) {
        super(size, direction, hits, isSunk, coordenadaX, coordenadaY);
        this.length = length;
        this.width = width;
    }
}