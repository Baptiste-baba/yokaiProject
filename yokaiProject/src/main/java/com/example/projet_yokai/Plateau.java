package com.example.projet_yokai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import java.io.IOException;



public class Plateau {

    @FXML
    private Label qui;
    @FXML
    private Button J1;
    @FXML
    private Button J2;
    @FXML
    private Button J3;
    @FXML
    private Button J4;

    MediaPlayer mediaPlayer;


    public void retourmenustg(ActionEvent event) throws IOException {
        menuprincipal();
    }

    private void menuprincipal() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("MenuPrincipal.fxml");
    }

    public void joue1(ActionEvent event) throws IOException{
        qui.setText("Au tour du joueur 1");
        J1.setStyle("-fx-background-color:#00FF3E; ");
        J2.setStyle("-fx-background-color:#E93689; ");
        J3.setStyle("-fx-background-color:#E93689; ");
        J4.setStyle("-fx-background-color:#E93689; ");
        qui.setStyle("-fx-background-color:#E93689; ");

    }
    public void joue2(ActionEvent event) throws IOException{
        qui.setText("Au tour du joueur 2");
        J2.setStyle("-fx-background-color:#00FF3E; ");
        J1.setStyle("-fx-background-color:#E93689; ");
        J3.setStyle("-fx-background-color:#E93689; ");
        J4.setStyle("-fx-background-color:#E93689; ");
        qui.setStyle("-fx-background-color:#E93689; ");
    }
    public void joue3(ActionEvent event) throws IOException{
        qui.setText("Au tour du joueur 3");
        J3.setStyle("-fx-background-color:#00FF3E; ");
        J2.setStyle("-fx-background-color:#E93689; ");
        J4.setStyle("-fx-background-color:#E93689; ");
        J1.setStyle("-fx-background-color:#E93689; ");
        qui.setStyle("-fx-background-color:#E93689; ");
    }
    public void joue4(ActionEvent event) throws IOException{
        qui.setText("Au tour du joueur 4");
        J4.setStyle("-fx-background-color:#00FF3E; ");
        J2.setStyle("-fx-background-color:#E93689; ");
        J3.setStyle("-fx-background-color:#E93689; ");
        J1.setStyle("-fx-background-color:#E93689; ");
        qui.setStyle("-fx-background-color:#E93689; ");
    }
    public void music(ActionEvent event) throws IOException{
        String fileName = "land-of-the-red-dragon-by-vindu-japanese-chill-music.mp3";
        playHitSound(fileName);
    }

    private void playHitSound(String fileName) {
        String path = getClass().getResource(fileName).getPath();
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
}
