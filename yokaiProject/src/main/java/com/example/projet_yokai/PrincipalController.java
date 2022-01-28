package com.example.projet_yokai;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class PrincipalController {

    @FXML
    private Button option;

    public void arrete(ActionEvent event){
        Platform.exit();
    }

    public void starting(ActionEvent event) throws IOException {
        menujoueur();
    }


    private void menujoueur() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("joueur.fxml");
    }

    public void menuoption(ActionEvent event) throws IOException {
        option();
    }

    private void option() throws IOException{
        HelloApplication m = new HelloApplication();
        m.changeScene("difficulte.fxml");
    }


}