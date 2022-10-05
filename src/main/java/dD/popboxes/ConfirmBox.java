package dD.popboxes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean resp;

    public static boolean display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label(message);


        //Create buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        //response gathering / confirmbox closing
        yesButton.setOnAction(e -> {
            resp = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            resp = false;
            window.close();
        });

        HBox layout = new HBox(10);
        layout.setPadding(new Insets(15, 12, 15, 12));
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return resp;
    }
}
