package org.example;

public class Canoe extends Ship {
    int length = 2;
    int width = 1;

    public Canoe(Point startPoint, CardinalPoints direction) {
        super(2, startPoint, calculateEndPoint(startPoint, direction), direction);
    }

    private static Point calculateEndPoint(Point startPoint, CardinalPoints direction) {
        int x = startPoint.getX();
        int y = startPoint.getY();

        switch (direction) {
            case NORTH:
                y--;
                break;
            case SOUTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }

        return new Point(x, y);
    }
}
