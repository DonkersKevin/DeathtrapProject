package dD.gamehandlers;

import dD.model.PlayerCharacter;
import javafx.event.ActionEvent;

import static dD.controllers.MainController.*;

public class EventParser {

    private FightHandler fightHandler;
    private StatChangeHandler statChangeHandler;
    private DeathHandler deathHandler;
    private DiceTestHandler diceTestHandler;

    public EventParser() {
        fightHandler = new FightHandler();
        statChangeHandler = new StatChangeHandler();
        deathHandler = new DeathHandler();
        diceTestHandler = new DiceTestHandler();
    }

    public void parseGameEvents(String gameSequence, PlayerCharacter p, ActionEvent event){

        String [] action = gameSequence.split(" ");


        switch (action[0]) {
            case "DEATH":
                deathMessage = currentLocation.getDescription();
                System.out.println("Death");
                deathHandler.death(event);
                break;

            case "TYL" :
                System.out.println("Testing luck");
                System.out.println(diceTestHandler.testYourLuck(playerCharacter.getLuck()));
                diceTestHandler.testYourLuck(playerCharacter.getLuck());
                break;

            case "TYS" :
                System.out.println("Testing skill");
                System.out.println(diceTestHandler.testYourSkill(playerCharacter.getSkill()));
                diceTestHandler.testYourSkill(playerCharacter.getSkill());
                break;

            case "TYLS" :
                System.out.println("Testing luck and skill");
                diceTestHandler.testYourStamAndSkill(playerCharacter.getStamina(), playerCharacter.getSkill());
                break;

            case "TYROLL8" :
                System.out.println("Test your roll / 8");
                diceTestHandler.testYourRoll8();
                break;

            case "TYROLLR" :
                System.out.println("Test your roll, ranging 1-2/3-4/5-6");
                diceTestHandler.testYourRollRange();
                break;

            case "CAPTURED" :
                System.out.println("Captured");
                deathHandler.captured();
                break;

            case "FIGHT" :
                System.out.println("Fight");
                fightHandler.pickFight(action[1], p);
                break;

            case "STAT" :
                System.out.println("Stat change imminent");
                statChangeHandler.parseStatChange(action);
                break;

            case "ADD" :
                System.out.println("Found something");
                playerCharacter.addToInventory(action[1]);
                break;

            case "LOSE" :
                System.out.println("Lost something");
                playerCharacter.removeFromInventory(action[1]);
                break;

            case "CHECK" :
                System.out.println("Checking inventory");
                checkInventory(action[1]);
                break;

            case "CHECKEVENT" :
                System.out.println("Checking event list");
                playerCharacter.checkEventList(action[1]);
                break;

            case "ADDEVENT" :
                System.out.println("Adding event to list");
                playerCharacter.addToEventList(action[1]);
                break;

            case "EAT" :
                System.out.println("Om nom nom nom");
                playerCharacter.eat();
                break;
        }
    }

    public boolean checkInventory(String item){
        return playerCharacter.checkInventory(item);
    }
}
