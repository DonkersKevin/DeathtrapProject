package dD.popboxes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CharacterSelectBox {

    public static void displayCharSelect() {

        Stage charWindow = new Stage();

        charWindow.initModality(Modality.APPLICATION_MODAL);
        charWindow.setTitle("Select your warrior");

        try {
            Parent root = (Parent) FXMLLoader.load(CharacterSelectBox.class.getResource("/fxml/charWindow.fxml"));
            charWindow.setScene(new Scene(root, 800, 600));
            charWindow.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
