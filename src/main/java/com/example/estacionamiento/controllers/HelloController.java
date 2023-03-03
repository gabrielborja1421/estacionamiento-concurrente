package com.example.estacionamiento.controllers;
import com.example.estacionamiento.models.Vector;
import com.example.estacionamiento.models.Vehiculo;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class HelloController implements Observer{
    private Random random;
    @FXML
    private ImageView carro;

    @FXML
    private ImageView carro10;

    @FXML
    private ImageView carro11;

    @FXML
    private ImageView carro12;

    @FXML
    private ImageView carro13;

    @FXML
    private ImageView carro14;

    @FXML
    private ImageView carro15;

    @FXML
    private ImageView carro16;

    @FXML
    private ImageView carro17;

    @FXML
    private ImageView carro18;

    @FXML
    private ImageView carro19;

    @FXML
    private ImageView carro20;

    @FXML
    private ImageView carro21;

    @FXML
    private ImageView carro22;

    @FXML
    private ImageView carro4;

    @FXML
    private ImageView carro5;

    @FXML
    private ImageView carro6;

    @FXML
    private ImageView carro7;

    @FXML
    private ImageView carro8;

    @FXML
    private ImageView carro9;

    @FXML
    private ImageView carroF;

    @FXML
    private ImageView carroF1;
    private Vehiculo vehiculo;
    @FXML
    public void initialize() {
        vehiculo = new Vehiculo();
        vehiculo.position(new Vector(1,10,10));
        vehiculo.addObserver(this);
        new Thread(vehiculo).start();

    }
    @Override
    public void update(Observable o, Object arg) {
        random = new Random(System.currentTimeMillis());
        Vector vector = (Vector) arg;

            switch (vector.getId()) {
                case 1:
                    Platform.runLater(() -> carroF.setLayoutX(vector.getY()));
                    System.out.println(vector.getId());
                    break;
                case 2:
                    Platform.runLater(() -> enemigo2.setLayoutX(vector.getX()));
                    System.out.println(vector.getId());
                    break;
                case 3:
                    Platform.runLater(() -> enemigo3.setLayoutX(vector.getX()));
                    System.out.println(vector.getId());
                    break;
            }


        }
        if(avionAliado.getBoundsInParent().intersects(enemigo.getBoundsInParent())|| avionAliado.getBoundsInParent().intersects(enemigo2.getBoundsInParent())|| avionAliado.getBoundsInParent().intersects(enemigo3.getBoundsInParent())) {
        //|| avionAliado.getBoundsInParent().intersects(enemigo2.getBoundsInParent())|| avionAliado.getBoundsInParent().intersects(enemigo2.getBoundsInParent())|| avionAliado.getBoundsInParent().intersects(enemigo3.getBoundsInParent())
        helicoptero.setEstado(false);
        helicoptero2.setEstado(false);
        helicoptero3.setEstado(false);
        end.setVisible(true);
        }



        if (enemigo.getLayoutX() <= -130){
        int aleatorio = random.nextInt((350));
        int aleatorio2 = random.nextInt((530));
        int aleatorio3 = random.nextInt((620));

        this.helicoptero.setEstado(false);
        this.enemigo.setVisible(false);

        this.helicoptero2.setEstado(false);
        this.enemigo2.setVisible(false);

        this.helicoptero3.setEstado(false);
        this.enemigo3.setVisible(false);


            if (!helicoptero.isEstado()) {
                this.helicoptero.setEstado(true);
                helicoptero.posicion(new Vector(1, 1400, aleatorio));
                this.enemigo.setVisible(true);
                enemigo.setLayoutY(aleatorio);
                enemigo.setLayoutX(1400);

                this.helicoptero2.setEstado(true);
                helicoptero2.posicion(new Vector(2, 1400, aleatorio2));
                this.enemigo2.setVisible(true);
                enemigo2.setLayoutY(aleatorio2);
                enemigo2.setLayoutX(1400);

                this.helicoptero3.setEstado(true);
                helicoptero3.posicion(new Vector(3, 1400, aleatorio3));
                this.enemigo3.setVisible(true);
                enemigo3.setLayoutY(aleatorio3);
                enemigo3.setLayoutX(1400);

            }
        }

    }
