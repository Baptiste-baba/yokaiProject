package com.example.projet_yokai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class Bienvenue {

    @FXML
    private Button Bienv;

    public Bienvenue() {

    }


    public void mainmenu(ActionEvent event) throws IOException {
        menuprincipal();
    }

    private void menuprincipal() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("MenuPrincipal.fxml");
    }



}
