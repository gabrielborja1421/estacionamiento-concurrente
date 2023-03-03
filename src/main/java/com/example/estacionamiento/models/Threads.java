package main.model;

import java.util.Observable;
import java.util.Random;

public class Threads extends Observable implements Runnable{
    private int cantidad;
    private Random random;

    public Threads(int cantidad){
        random = new Random(System.currentTimeMillis());
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        int cont = 0;
        for (int i = 0; i<cantidad; i++){

            this.setChanged();
            this.notifyObservers(String.valueOf(i));

            try {
                Thread.sleep(random.nextInt(400)+100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
