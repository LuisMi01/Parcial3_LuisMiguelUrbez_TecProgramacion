package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Point {
    protected int x;
    protected int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void get_ship(Point point){
        System.out.println("El barco esta en la posicion: " + point.x + " " + point.y);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
