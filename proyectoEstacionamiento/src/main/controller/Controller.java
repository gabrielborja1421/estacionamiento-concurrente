package main.controller;

import main.model.Auto;
import main.model.Threads;
import main.model.espacioE;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;

import java.util.Observable;
import java.util.Observer;

import java.util.concurrent.Semaphore;



public class Controller implements Observer{
    @FXML
    private AnchorPane canvas;
    @FXML private Button botonIniciar;
    Semaphore puerta = new Semaphore(1);
    Semaphore puedeEntrar = new Semaphore(0);
    Semaphore puedeSalir = new Semaphore(0);
    Auto[] carro = new Auto[100];
    espacioE[] celdas = new espacioE[20];


    @FXML
    void iniciarClic() {
        botonIniciar.setDisable(true);
        Threads threads = new Threads(carro.length);
        threads.addObserver(this);
        new Thread(threads).start();
    }


    @FXML
    public void initialize(){
        for (int i = 0; i<carro.length; i++){
            carro[i] = new Auto(new Image("file:src/main/resources/auto"+(int) Math.floor(Math.random()*5+1)+".png"),puerta,puedeEntrar,puedeSalir,celdas);
            canvas.getChildren().add(carro[i]);
        }
        for (int i = 0; i<10; i++){
            celdas[i] = new espacioE(false,i*70,70, 180);
        }
        for (int i = 10; i<20; i++){
            celdas[i] = new espacioE(false,(i-10)*70,390, 0);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        carro[Integer.valueOf((String) arg)].init();
    }
}
