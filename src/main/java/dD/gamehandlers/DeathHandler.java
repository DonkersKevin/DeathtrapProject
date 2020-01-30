package dD.gamehandlers;

import dD.popboxes.DeathBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class DeathHandler {

    private DeathBox deathBox = new DeathBox();

    public void death(ActionEvent event){
        Button bPressed = (Button) event.getSource();
        Stage stage = (Stage) bPressed.getScene().getWindow();
        stage.close();

        deathBox.displayDeathBox();
    }

    public void captured(){
        deathBox.displayDeathBox();
    }
}
