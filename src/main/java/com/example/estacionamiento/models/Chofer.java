package com.example.estacionamiento.models;

public class Chofer {
    private int id;
    private int x;
    private int y;

    public int getId() {
        return id;
    }

    public Chofer(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
