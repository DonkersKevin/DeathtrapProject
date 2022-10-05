package dD.popboxes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DeathBox {
    public void displayDeathBox() {

        Stage deathWindow = new Stage();

        deathWindow.initModality(Modality.APPLICATION_MODAL);
        deathWindow.setTitle("You have died.");

        try {
            Parent root = (Parent) FXMLLoader.load(dD.popboxes.DeathBox.class.getResource("/fxml/deathWindow.fxml"));
            deathWindow.setScene(new Scene(root, 800, 600));
            deathWindow.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

