package dD.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class DdApp extends Application {
    Media media;


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));

        /*        Parent root = FXMLLoader.load(getClass().getResource("/fxml/gameWindow.fxml"));*/


        stage.setScene(new Scene(root, 800, 600));

        //Media
        String path = "src/main/resources/music/148_Barovian_Castle.mp3";
        media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.1);

        //Fonts
        Font.loadFont(getClass().getResourceAsStream("/fonts/EnchantedLand-jnX9.ttf"), 25);

        stage.setTitle("Deathtrap Dungeon");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
