package main.model;

public class espacioE {
    private boolean ocupado;
    private double posX;
    private double posY;
    private double orientacion;

    public espacioE(boolean ocupado, double posX, double posY, double orientacion){
        this.ocupado = ocupado;
        this.posX = posX;
        this.posY = posY;
        this.orientacion = orientacion;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    public boolean isOcupado() {
        return ocupado;
    }
    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }
    public double getOrientacion() { return orientacion; }

}
