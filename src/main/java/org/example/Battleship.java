package org.example;

import java.util.List;

public class Battleship implements Ship {
    enum estado{
        INTACTO,
        TOCADO,
        HUNDIDO,
        AGUA
    }
    protected String estadoBarco;

    protected int size = 5;
    protected Point startPoint;
    protected Point endPoint;
    protected CardinalPoints direction;
    protected int vida = 5;
    protected int hits;

    public Battleship( Point startPoint, Point endPoint, CardinalPoints direction) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.direction = direction;
        this.hits = 0;
    }

    public boolean isSunk() {
        return hits == size;
    }

    public boolean getShot(Point shotPoint) {
        if (isHit(shotPoint)) {
            hits++;
            return true;
        }
        return false;
    }

    public void updateState(Point shot) {
        estado estadoActual = estado.INTACTO;
        if (this.isSunk()) {
            setEstadoBarco("HUNDIDO");
        }
        if (this.isHit(shot)) {
            this.hits++;
            estadoActual = estado.TOCADO;
            setEstadoBarco("TOCADO");
            if (this.isSunk()) {
                estadoActual = estado.HUNDIDO;
                setEstadoBarco("HUNDIDO");
            }
        } else {
            estadoActual = estado.AGUA;
            setEstadoBarco("AGUA");
        }

    }
    private boolean isHit(Point shot) {
        switch (this.direction) {
            case NORTH:
                if (shot.getX() != this.startPoint.getX()) {
                    return false;
                }
                for (int i = this.startPoint.getY(); i <= this.endPoint.getY(); i++) {
                    if (shot.getY() == i) {
                        return true;
                    }
                }
                break;
            case SOUTH:
                if (shot.getX() != this.startPoint.getX()) {
                    return false;
                }
                for (int i = this.startPoint.getY(); i >= this.endPoint.getY(); i--) {
                    if (shot.getY() == i) {
                        return true;
                    }
                }
                break;
            case EAST:
                if (shot.getY() != this.startPoint.getY()) {
                    return false;
                }
                for (int i = this.startPoint.getX(); i <= this.endPoint.getX(); i++) {
                    if (shot.getX() == i) {
                        return true;
                    }
                }
                break;
            case WEST:
                if (shot.getY() != this.startPoint.getY()) {
                    return false;
                }
                for (int i = this.startPoint.getX(); i >= this.endPoint.getX(); i--) {
                    if (shot.getX() == i) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    //get y set
    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    public String getEstadoBarco() {
        return estadoBarco;
    }

    public void setEstadoBarco(String estadoBarco) {
        this.estadoBarco = estadoBarco;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public void setDirection(CardinalPoints direction) {
        this.direction = direction;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}

