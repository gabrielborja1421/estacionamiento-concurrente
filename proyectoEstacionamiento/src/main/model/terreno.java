package main.model;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.Observable;


public class terreno extends Observable implements Runnable{
    private Semaphore puerta;
    private Semaphore puedeEntrar;
    private Semaphore puedeSalir;
    private espacioE[] espacioE;
    private double position;
    private boolean fin = false;
    private int lleno = 100;
    private int timer = 45;
    private Random random;

    public terreno(double position,Semaphore puerta, Semaphore puedeEntrar, Semaphore puedeSalir, espacioE[] estacionamiento){
        this.position = position;
        this.puerta = puerta;
        this.puedeEntrar = puedeEntrar;
        this.puedeSalir = puedeSalir;
        this.espacioE = estacionamiento;
        random = new Random(System.currentTimeMillis());
    }

    public int checkOcupado(){
        for (int i = 0; i<espacioE.length; i++){
            if(!espacioE[i].isOcupado())
                return i;
        }
        return 100;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        try {
            puerta.acquire();
            if (salidaEntrada.recurso || checkOcupado() > 20){
                salidaEntrada.entrando++;
                puerta.release();
                puedeEntrar.acquire();
                salidaEntrada.entrando--;
            }
            salidaEntrada.recurso = true;
            int checkOcupado = checkOcupado();
            espacioE[checkOcupado].setOcupado(true);
            puerta.release();

            while(!fin){ //anima
                position = position + timer;
                this.setChanged();
                this.notifyObservers(new nodoAuto(position,214,-90));
                if (position > 300)
                    fin = true;
                Thread.sleep(17);
            }
            this.setChanged();
            this.notifyObservers(new nodoAuto(espacioE[checkOcupado].getPosX(),espacioE[checkOcupado].getPosY(),espacioE[checkOcupado].getOrientacion()));

            puerta.acquire();
            salidaEntrada.recurso = false;
            if(salidaEntrada.entrando > 0 && checkOcupado() != lleno)
                puedeEntrar.release();
            else if(salidaEntrada.saliendo > 0)
                puedeSalir.release();
            else puerta.release();
            Thread.sleep(random.nextInt(4000)+1000);

            puerta.acquire();
            if (salidaEntrada.recurso){
                salidaEntrada.saliendo++;
                puerta.release();
                puedeSalir.acquire();
                salidaEntrada.saliendo--;
            }
            salidaEntrada.recurso = true;
            espacioE[checkOcupado].setOcupado(false);
            puerta.release();

            position = 300;
            fin = false;
            this.setChanged();
            this.notifyObservers(new nodoAuto(position,214,90));
            while (!fin){
                position = position - timer;
                this.setChanged();
                this.notifyObservers(new nodoAuto(position,214,90));
                if (position < -160)
                    fin = true;
                Thread.sleep(17);
            }

            puerta.acquire();
            salidaEntrada.recurso = false;

            if(salidaEntrada.saliendo>0)
                puedeSalir.release();
            else if (salidaEntrada.entrando>0 && checkOcupado() != 500)
                puedeEntrar.release();
            else puerta.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
