package org.example;


public interface Ship {

        int getSize();

        Point getStartPoint();

        Point getEndPoint();

        public void updateState(Point point);

        boolean isSunk();

        boolean getShot(Point shotPoint);



    }


