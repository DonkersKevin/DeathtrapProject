package dD.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenController {

    @FXML
    public void startButtonClicked(ActionEvent event) {

        try {
            System.out.println("Starting game");
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

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
