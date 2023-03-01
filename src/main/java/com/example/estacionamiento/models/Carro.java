package com.example.estacionamiento.models;
import java.util.Observable;


public class Carro extends Observable implements Runnable{
    private Chofer chofer;
    private boolean estado;

    public Carro(){
        estado=true;
    }
    public void posicion(Chofer chofer){
        this.chofer=chofer;
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
            notifyObservers(chofer);
            try {
                Thread.sleep(100L);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
