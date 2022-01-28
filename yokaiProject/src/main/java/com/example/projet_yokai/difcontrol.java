package com.example.projet_yokai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class difcontrol {
    @FXML
    private Button niv1;
    @FXML
    private Button niv2;
    @FXML
    private Button niv3;
    @FXML
    private Button niv4;
    @FXML
    private Label choix;

    public void niveau1(ActionEvent event){
        System.out.println("Le niveau de difficulté 1 est activé");
        choix.setText("Le niveau de difficulté choisit est maintenant le niveau 1");
    }
    public void niveau2(ActionEvent event){
        System.out.println("Le niveau de difficulté 2 est activé");
        choix.setText("Le niveau de difficulté choisit est maintenant le niveau 2");
    }
    public void niveau3(ActionEvent event){
        System.out.println("Le niveau de difficulté 3 est activé");
        choix.setText("Le niveau de difficulté choisit est maintenant le niveau 3");
    }
    public void niveau4(ActionEvent event){
        System.out.println("Le niveau de difficulté 4 est activé");
        choix.setText("Le niveau de difficulté choisit est maintenant le niveau 4");
    }

    public void mainmenu(ActionEvent event) throws IOException {
        menuprincipal();
    }
    private void menuprincipal() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("MenuPrincipal.fxml");
    }
}
