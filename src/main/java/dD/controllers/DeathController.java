package dD.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static dD.controllers.MainController.deathMessage;

public class DeathController {

    @FXML
    private Text deathNote;

    public void initialize() {
        deathNote.setText(deathMessage);
    }


    public void handleDeathExitButton(ActionEvent event) {
        Button bPressed = (Button) event.getSource();
        Stage stage = (Stage) bPressed.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void handleRestartButton(ActionEvent event) {
        try {
            Button bPressed = (Button) event.getSource();
            Stage stageOld = (Stage) bPressed.getScene().getWindow();
            stageOld.close();

            Stage stage = new Stage();

            // Swap screen
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/gameWindow.fxml"));
            stage.setScene(new Scene(root, 800, 600));
            stage.show();

            // Call code segment before closing app.
            stage.setOnCloseRequest(e -> {
                e.consume();
                closeProgram();
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeProgram() {
        Platform.exit();
    }
}
