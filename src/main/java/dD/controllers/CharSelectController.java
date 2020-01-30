package dD.controllers;

import dD.model.PlayerCharacter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CharSelectController {

    public static PlayerCharacter selectedCharacter;

    //Opens character select screen
    @FXML
    public void handleCharSelectButton(javafx.event.ActionEvent event) {
        Button b = (Button)(event.getSource());
        String choice = b.getText();
        System.out.println(choice + " chosen.");
        selectCharacter(choice);


        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
    }

    static void selectCharacter(String choice){
        switch(choice){
            case "Aran Gottspeed":
                selectedCharacter = new PlayerCharacter("Aran Gottspeed",23,8,7,"STAMINA", 6);
                break;
            case "Baldar Liefsson" :
                selectedCharacter = new PlayerCharacter("Baldar Liefsson", 17,12,9,"SKILL",6);
                break;
            case "Ariel Elfhart" :
                selectedCharacter = new PlayerCharacter("Ariel Elfhart", 18,9,11,"FORTUNE",6);
                break;
        }
    }
}
