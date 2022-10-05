package dD.popboxes;

import dD.model.Monster;
import dD.model.PlayerCharacter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static dD.controllers.MainController.monsterToFight;

public class FightBox {

    public void displayFightBox(PlayerCharacter playerCharacter, Monster m) {

        Stage fightWindow = new Stage();

        fightWindow.initModality(Modality.APPLICATION_MODAL);
        fightWindow.setTitle("Fight!");

        try {
            Parent root = (Parent) FXMLLoader.load(FightBox.class.getResource("/fxml/fightWindow.fxml"));
            fightWindow.setScene(new Scene(root, 800, 600));
            fightWindow.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
