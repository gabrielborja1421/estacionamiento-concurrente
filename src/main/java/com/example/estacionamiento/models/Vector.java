package com.example.estacionamiento.models;

public class Vector {
    private int id;
    private int x;

    public int getId() {
        this.id = id;

        return id;
    }

    public Vector(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    private int y;

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
