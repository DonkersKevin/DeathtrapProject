package dD.controllers;

import dD.model.Die;
import dD.popboxes.ConfirmBox;
import dD.popboxes.DeathBox;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

import static dD.controllers.MainController.monsterToFight;
import static dD.controllers.MainController.playerCharacter;


public class FightController {

    private Die die = new Die();
    private StringBuilder combatLogString;

    @FXML
    private ImageView playerPic;

    @FXML
    private ImageView monsterPic;


    @FXML
    private Button strikeButton;
    @FXML
    private Button fleeButton;
    @FXML
    private Button drinkButton;

    @FXML
    private Text combatLog;

    @FXML
    private Text monsterName;
    @FXML
    private Text monsterStam;
    @FXML
    private Text monsterSkill;

    @FXML
    private Text playerName;
    @FXML
    private Text playerStam;
    @FXML
    private Text playerSkill;
    @FXML
    private Text playerLuck;
    @FXML
    private Text playerPots;
    @FXML
    private Text potionChoice;

    @FXML
    private void initialize() {
        System.out.println("Setup...");

        combatLog.setText("Start of combat");
        combatLogString = new StringBuilder(combatLog.getText());


        System.out.println("setting up monster");
        monsterName.setText(monsterToFight.getName());
        System.out.println(monsterToFight.getName());


        monsterStam.setText(Integer.toString(monsterToFight.getStamina()));
        monsterSkill.setText(Integer.toString(monsterToFight.getSkill()));
        monsterPic.setImage(new Image("images/Baldar.jpg"));

        /*playerCharacter.*/

        playerName.setText(playerCharacter.getName());
        playerStam.setText(Integer.toString(playerCharacter.getStamina()));
        playerSkill.setText(Integer.toString(playerCharacter.getSkill()));
        playerLuck.setText(Integer.toString(playerCharacter.getLuck()));
        playerPots.setText(Integer.toString(playerCharacter.getPotionUses()));
        potionChoice.setText(playerCharacter.getPotionChoice().toLowerCase());

        switch (playerCharacter.getName()){
            case "Aran Gottspeed" : playerPic.setImage(new Image("images/Arran.png"));
                break;

            case "Baldar Liefsson" : playerPic.setImage(new Image("images/Baldar.jpg"));
                break;

            case "Ariel Elfhart" : playerPic.setImage(new Image("images/Ariel.png"));
                break;
        }

        //listeners
        playerCharacter.staminaProperty().addListener((v, oldValue, newValue) -> {
            playerStam.setText(newValue.toString());
        });

        playerCharacter.skillProperty().addListener((v, oldValue, newValue) -> {
            playerSkill.setText(newValue.toString());
        });

        playerCharacter.luckProperty().addListener((v, oldValue, newValue) -> {
            playerLuck.setText(newValue.toString());
        });

        playerCharacter.potionUsesProperty().addListener((v, oldValue, newValue) -> {
            playerPots.setText(newValue.toString());
        });

        monsterToFight.staminaProperty().addListener((v, oldValue, newValue) -> {
            monsterStam.setText(newValue.toString());
        });
    }

    public void handleStrikeButton(javafx.event.ActionEvent event){
        resolveStrike(event);
    }

    public void handleFleeButton(javafx.event.ActionEvent event){
        System.out.println("Fleeing!");

    }

    public void handleDrinkButton(javafx.event.ActionEvent event){
        System.out.println("Drinking a potion.");
        if(playerCharacter.getPotionUses()>0){
            if(playerCharacter.drinkPotion(playerCharacter.getPotionChoice())){
                playerCharacter.setPotionUses(playerCharacter.getPotionUses()-1);
            }else{
                combatLogString.append(System.getProperty("line.separator"));
                combatLogString.append("You don't need to use a potion!");
                combatLog.setText(combatLogString.toString());
            }
        }else{
            combatLogString.append(System.getProperty("line.separator"));
            combatLogString.append("You have no more potion uses!");
            combatLog.setText(combatLogString.toString());
        }

    }

    private void resolveStrike(javafx.event.ActionEvent event){
        int enemyRoll = die.rollTwoDice() + monsterToFight.getSkill();
        int playerRoll = die.rollTwoDice() + playerCharacter.getSkill();

        if(enemyRoll==playerRoll){
            combatLogString.append(System.getProperty("line.separator"));
            combatLogString.append("Your blows glance.");
            combatLog.setText(combatLogString.toString());

        }else if(enemyRoll>playerRoll){
            combatLogString.append(System.getProperty("line.separator"));
            combatLogString.append("The enemy hits you!");
            combatLog.setText(combatLogString.toString());

            playerCharacter.setStamina(playerCharacter.getStamina()-2);
            if(playerCharacter.getStamina()<=0){
                playerDead(event);
            }

        }else{
            combatLogString.append(System.getProperty("line.separator"));
            combatLogString.append("You hit the enemy!");
            combatLog.setText(combatLogString.toString());

            monsterToFight.setStamina(monsterToFight.getStamina()-2);
            if(monsterToFight.getStamina()<=0){
                monsterDead(event);
            }
        }

    }


    private void playerDead(javafx.event.ActionEvent event){
        System.out.println("Player has died");
        Button buttonPressed = (Button) event.getSource();
        Stage stage = (Stage) buttonPressed.getScene().getWindow();
        stage.close();
/*        ConfirmBox.display("You have lost", "Restart?" );*/
    }

    private void monsterDead(javafx.event.ActionEvent event){
        System.out.println("Victory!");
        Button buttonPressed = (Button) event.getSource();
        Stage stage = (Stage) buttonPressed.getScene().getWindow();
        stage.close();
    }


}
