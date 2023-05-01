package org.example;

public class Battleship extends Ship {
    int length = 5;
    int width = 1;

    public Battleship(Point startPoint, CardinalPoints direction, int length, int width) {
        super(5, startPoint, calculateEndPoint(startPoint, direction), direction);
        this.length = length;
        this.width = width;
    }

    public Point calculateEndPoint() {
        int x, y;
        switch (direction) {
            case NORTH:
                x = startPoint.getX();
                y = startPoint.getY() - length + 1;
                break;
            case SOUTH:
                x = startPoint.getX();
                y = startPoint.getY() + length - 1;
                break;
            case WEST:
                x = startPoint.getX() - length + 1;
                y = startPoint.getY();
                break;
            case EAST:
                x = startPoint.getX() + length - 1;
                y = startPoint.getY();
                break;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
        return new Point(x, y);
    }

        return new Point(x, y);
    }
}
