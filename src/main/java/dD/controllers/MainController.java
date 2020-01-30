package dD.controllers;

import dD.dao.EventPool;
import dD.model.Location;
import dD.dao.LocationsPool;
import dD.model.Monster;
import dD.model.PlayerCharacter;
import dD.model.SaveableCharacter;
import dD.popboxes.CharacterSelectBox;
import dD.popboxes.ConfirmBox;
import dD.gamehandlers.GameEventHandler;
import dD.util.SaveLoadService;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.image.*;

import static dD.controllers.CharSelectController.selectedCharacter;


public class MainController {

    private static LocationsPool loc;
    public static Location currentLocation;

    public static PlayerCharacter playerCharacter;
    public static String deathMessage;
    public static boolean testPassed;
    public static boolean isTestPassed;

    public static Monster monsterToFight;

    public static EventPool eventPool = new EventPool();
    public static GameEventHandler gameEventHandler = new GameEventHandler();
    public static SaveLoadService saveLoadService;



    //location
    @FXML
    private Text locationDescription;

    //Character
    @FXML
    private Text characterName;
    @FXML
    private Text staminaC;
    @FXML
    private Text skillC;
    @FXML
    private Text luckC;
    @FXML
    private Text provisionC;
    @FXML
    private Text potionC;
    @FXML
    private Text potionType;


    @FXML
    private List<String> inventoryList;

    @FXML
    private ListView inventoryView;

    @FXML
    private ImageView characterPic;

    @FXML
    private ImageView locationImagery;



    @FXML
    private Button buttonA;
    @FXML
    private Button buttonB;
    @FXML
    private Button buttonC;
    @FXML
    private Button buttonD;
    @FXML
    private Button buttonE;
    @FXML
    private Button buttonF;

    @FXML
    private Button eatButton;
    @FXML
    private Button drinkButton;

    @FXML
    private Text descrA;
    @FXML
    private Text descrB;
    @FXML
    private Text descrC;
    @FXML
    private Text descrD;
    @FXML
    private Text descrE;
    @FXML
    private Text descrF;


    public void restartGame(javafx.event.ActionEvent event){
        Button b = (Button)(event.getSource());
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();


        System.out.println("restart");
        System.out.println(playerCharacter.getName());
/*        selectCharacter(playerCharacter.getName());*/
        currentLocation = loc.getLocation(1);
        System.out.println(currentLocation.getLocationID());
        //Nullpointer
/*        locationDescription.setText(currentLocation.getDescription());*/
    }


    public void initialize(){
    loc = new LocationsPool();
    currentLocation = loc.getLocation(1);


    eventPool = new EventPool();
    saveLoadService = new SaveLoadService();
    gameEventHandler = new GameEventHandler();

    descrA.setText("-");
    descrB.setText("-");
    descrC.setText("-");
    descrD.setText("-");
    descrE.setText("-");
    descrF.setText("-");

    locationImagery.setImage(new Image("images/startImage.bmp"));

    deathMessage = "-";

    buttonA.setDisable(true);
    buttonB.setDisable(true);
    buttonC.setDisable(true);
    buttonD.setDisable(true);
    buttonE.setDisable(true);
    buttonF.setDisable(true);

    eatButton.setDisable(true);
    drinkButton.setDisable(true);

    }


    // Move Button handling
    @FXML
    public void handleNewGameButton(){
        //Display character selection box
        CharacterSelectBox.displayCharSelect();

        //Setup starting position
        currentLocation = loc.getLocation(1);
        locationDescription.setText(currentLocation.getDescription());

        //Setup character
        //Name
        playerCharacter = selectedCharacter;
        characterName.setText(playerCharacter.getName());


        System.out.println(playerCharacter.getName());
        switch (playerCharacter.getName()){
            case "Aran Gottspeed" : characterPic.setImage(new Image("images/Arran.png"));
            break;

            case "Baldar Liefsson" : characterPic.setImage(new Image("images/Baldar.jpg"));
            break;

            case "Ariel Elfhart" : characterPic.setImage(new Image("images/Ariel.png"));
            break;
        }

        //Stats
        staminaC.setText(Integer.toString(playerCharacter.getStamina()));
        skillC.setText(Integer.toString(playerCharacter.getSkill()));
        luckC.setText(Integer.toString(playerCharacter.getLuck()));

        //Useables
        provisionC.setText(Integer.toString(playerCharacter.getProvisions()));
        potionC.setText(Integer.toString(playerCharacter.getPotionUses()));
        potionType.setText(playerCharacter.getPotionChoice().toLowerCase());

        //Inventory
        inventoryView.setItems((ObservableList) playerCharacter.getInventory().getInventoryList());

        //listeners
        playerCharacter.staminaProperty().addListener((v, oldValue, newValue) ->{
            staminaC.setText(newValue.toString());
            });

        playerCharacter.skillProperty().addListener((v, oldValue, newValue) ->{
            skillC.setText(newValue.toString());
        });

        playerCharacter.luckProperty().addListener((v, oldValue, newValue) ->{
            luckC.setText(newValue.toString());
        });

        playerCharacter.potionUsesProperty().addListener((v, oldValue, newValue) -> {
            provisionC.setText(newValue.toString());
        });

        playerCharacter.potionUsesProperty().addListener((v, oldValue, newValue) -> {
            potionC.setText(newValue.toString());
        });

        //Buttons
        eatButton.setDisable(false);
        drinkButton.setDisable(false);

        //Set button text and user access.
        updateButtons();
    }

    @FXML
    public void handleSaveButton(){
        System.out.println("Saving...");
        saveLoadService.save(playerCharacter,currentLocation);
    }

    @FXML
    public void handleLoadButton(){
        System.out.println("Loading...");
        SaveableCharacter sav = saveLoadService.load("EnterSaveStringHere");
        currentLocation = loc.getLocation(sav.getCurrentLocationID());

        System.out.println(currentLocation.getLocationID());
        System.out.println(currentLocation.getEventSequence());

        characterName.setText(playerCharacter.getName());
        locationDescription.setText(currentLocation.getDescription());

        updateButtons();
    }

    @FXML
    public void handleExitButton(){
        closeProgram();
    }

    @FXML
    public void handleDrinkButton(){
        System.out.println("Drinking");
    }

    @FXML
    public void handleEatButton(){
        System.out.println("Eating");
    }


    //Movement buttons
    @FXML
    public void handleMoveButton(ActionEvent event){
        //Gets button text to query locations database for next location
        Button buttonPressed = (Button) event.getSource();
        System.out.println(buttonPressed.getText() + " Pressed.");
        currentLocation = loc.getLocation(currentLocation.getExits().get(buttonPressed.getText().toLowerCase()));

        //Updates Center text
        locationDescription.setText(currentLocation.getDescription());

        //Parse eventSequence string
        gameEventHandler.parseEventSequence(currentLocation.getEventSequence(), playerCharacter, event);
/*        if(testFailed){

        }*/

        //Updates buttons
        updateButtons();
        System.out.println("Location number : " + currentLocation.getLocationID());
    }


    //Manual update of buttons, deactivates unnused buttons, reactivates usable buttons
    private void updateButtons(){
        String descr = currentLocation.getExitDescription().get("a");
        if (descr != null){
            descrA.setText(descr);
            buttonA.setDisable(false);
        }else{
            descrA.setText("-");
            buttonA.setDisable(true);
        }

        descr = currentLocation.getExitDescription().get("b");
        if (descr != null){
            descrB.setText(descr);
            buttonB.setDisable(false);
        }else{
            descrB.setText("-");
            buttonB.setDisable(true);
        }

        descr = currentLocation.getExitDescription().get("c");
        if (descr != null){
            descrC.setText(descr);
            buttonC.setDisable(false);
        }else{
            descrC.setText("-");
            buttonC.setDisable(true);
        }

        descr = currentLocation.getExitDescription().get("d");
        if (descr != null){
            descrD.setText(descr);
            buttonD.setDisable(false);
        }else{
            descrD.setText("-");
            buttonD.setDisable(true);
        }

        descr = currentLocation.getExitDescription().get("e");
        if (descr != null){
            descrE.setText(descr);
            buttonE.setDisable(false);
        }else{
            descrE.setText("-");
            buttonE.setDisable(true);
        }

        descr = currentLocation.getExitDescription().get("f");
        if (descr != null){
            descrF.setText(descr);
            buttonF.setDisable(false);
        }else{
            descrF.setText("-");
            buttonF.setDisable(true);
        }

        System.out.println("Buttons updated");
    }


    //Code to run before close
    private void closeProgram(){
        Boolean answer = ConfirmBox.display("Close Program.", "Are you sure you want to exit?, Progress will be saved");
        if(answer){
            System.out.println("Progress Saved");
            saveLoadService.save(playerCharacter,currentLocation);
            Platform.exit();
        }
    }
}
