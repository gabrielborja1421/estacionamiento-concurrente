package main.model;

public class nodoAuto {
    private double posX;
    private double posY;
    private double orientacion;

    public nodoAuto(double posX, double posY, double orientacion){
        this.posX = posX;
        this.posY = posY;
        this.orientacion = orientacion;
    }

    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }
    public double getOrientacion() { return orientacion; }
}
