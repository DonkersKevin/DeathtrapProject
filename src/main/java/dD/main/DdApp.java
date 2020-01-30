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


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));

/*        Parent root = FXMLLoader.load(getClass().getResource("/fxml/gameWindow.fxml"));*/


        stage.setScene(new Scene (root, 800,600));

        //Media
        String path = "D:/UdemyWorkspace/deathtrapDungeon/src/main/resources/music/148_Barovian_Castle.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        //Fonts
        Font.loadFont(getClass().getResourceAsStream("/fonts/EnchantedLand-jnX9.ttf"),25);

        stage.setTitle("Deathtrap Dungeon");
        stage.show();

/*        Media mp3MusicFile = new Media(getClass().getResource("D:\\UdemyWorkspace\\deathtrapDungeon\\src\\main\\resources\\music\\148_Barovian_Castle.mp3").toExternalForm());
        MediaPlayer musicPlayer = new MediaPlayer(mp3MusicFile);
        musicPlayer.setAutoPlay(true);
        musicPlayer.setVolume(0.9);   // from 0 to 1*/
    }

    public static void main(String[] args) {
        launch(args);
    }

/*        MediaPlayer musicplayer; {
            Media mp3MusicFile = new Media(getClass().getResource("D:\\UdemyWorkspace\\deathtrapDungeon\\src\\main\\resources\\music\\148_Barovian_Castle.mp3").toExternalForm());

            musicplayer = new MediaPlayer(mp3MusicFile);
            musicplayer.setAutoPlay(true);
            musicplayer.setVolume(0.9);   // from 0 to 1

            //***************** loop (repeat) the music  ******************
            musicplayer.setOnEndOfMedia(new Runnable() {
                public void run() {
                    musicplayer.seek(Duration.ZERO);
                }
            });

        }*/
}
