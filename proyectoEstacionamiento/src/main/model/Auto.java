package main.model;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;
public class Auto extends ImageView implements Observer{
    private Semaphore puerta;
    private Semaphore puedeEntrar;
    private Semaphore puedeSalir;
    private espacioE[] espacioE;

    public Auto(Image carro, Semaphore puerta, Semaphore puedeEntrar, Semaphore puedeSalir, espacioE[] estacionamiento){
        this.puerta = puerta;
        this.puedeEntrar = puedeEntrar;
        this.puedeSalir = puedeSalir;
        this.espacioE = estacionamiento;
        this.setImage(carro);
        this.setLayoutX(300);
        this.setLayoutY(-150);
        this.setPreserveRatio(true);
        this.setFitHeight(125);
        this.setFitWidth(125);
    }

    public void init(){
        terreno estacionamiento = new terreno(this.getLayoutY(),puerta,puedeEntrar,puedeSalir,espacioE);
        estacionamiento.addObserver(this);
        new Thread(estacionamiento).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        nodoAuto pos = (nodoAuto) arg;
        Platform.runLater(()->{
            System.out.println("carro");
            this.setRotate(pos.getOrientacion());
            this.setLayoutX(pos.getPosX());
            this.setLayoutY(pos.getPosY());
        });
    }
}
