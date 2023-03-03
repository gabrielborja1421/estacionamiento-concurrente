package com.example.estacionamiento.models;
import com.example.estacionamiento.controllers.HelloController;

import java.util.Observable;


public class Vehiculo extends Observable implements Runnable{
    private boolean estado;
    private Vector vector;
    public void position(Vector vector){
        this.vector=vector;

    }
    public Vehiculo(){
        estado=true;
    }

    public void setEstado(boolean estado){
        this.estado= estado;
    }
    public boolean isEstado() {
        return estado;
    }

    @Override
    public void run() {
        while (estado){
            vector.setX(vector.getY()-35);
            setChanged();
            notifyObservers(vector);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }

    public void addObserver(HelloController o) {
    }
}
