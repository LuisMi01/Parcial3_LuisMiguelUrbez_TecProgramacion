package org.example;


public interface Ship {

        int getSize();

        Point getStartPoint();
        Point getEndPoint();

        void updateState(Point point);

        boolean isSunk();

        boolean getShot(Point shotPoint);

        CardinalPoints getDirection();
}


