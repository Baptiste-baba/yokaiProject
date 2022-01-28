package com.example.projet_yokai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class listejoueur {

    @FXML
    private TextField joueur1;
    @FXML
    private TextField joueur2;
    @FXML
    private TextField joueur3;
    @FXML
    private TextField joueur4;

    public void mainmenu(ActionEvent event) throws IOException {
        menuprincipal();
    }

    public void texttoj1(ActionEvent event){
        System.out.println(joueur1.getText());
    }

    public void texttoj2(ActionEvent event){
        System.out.println(joueur2.getText());
    }

    public void texttoj3(ActionEvent event){
        System.out.println(joueur3.getText());
    }

    public void texttoj4(ActionEvent event){
        System.out.println(joueur4.getText());
    }

    public void affiche(ActionEvent event){
        System.out.println(joueur1);
    }

    private void menuprincipal() throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("plateau.fxml");
    }
}
