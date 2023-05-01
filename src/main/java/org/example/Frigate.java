package org.example;

import java.util.ArrayList;

public class Frigate extends Ship {
    int length = 3;
    int width = 1;

    public Frigate(Point startPoint, CardinalPoints direction) {
        super(5, startPoint, calculateEndPoint(startPoint, direction), direction);
    }

    private static Point calculateEndPoint(Point startPoint, CardinalPoints direction) {
        int x = startPoint.getX();
        int y = startPoint.getY();

        switch (direction) {
            case NORTH:
                y -= 2;
                break;
            case SOUTH:
                y += 2;
                break;
            case EAST:
                x += 2;
                break;
            case WEST:
                x -= 2;
                break;
        }

        return new Point(x, y);

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
