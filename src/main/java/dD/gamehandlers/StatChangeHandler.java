package dD.gamehandlers;

import dD.model.Die;

import static dD.controllers.MainController.playerCharacter;

public class StatChangeHandler {

    private Die die;
    private int amount;

    public StatChangeHandler() {
        this.die = new Die();
        this.amount = 0;
    }

    public void parseStatChange(String [] statChanges){


    if(statChanges[1].equals("-1D6+1")){
        amount = 0 - die.rollOneDie() + 1;
    }else

    if(statChanges[1].equals("-1D6+2")){
        amount = 0 - die.rollOneDie() + 2;
    }else

    if(statChanges[1].equals("-1D6*2")){
        amount = 0 - die.rollOneDie() *2;
    }else

    if(statChanges[1].equals("-2D6")){
        amount = 0 - die.rollTwoDice();
    }else{
        amount = Integer.parseInt(statChanges[1]);
    }


    switch(statChanges[2]){
        case "STAM" : playerCharacter.setStamina(playerCharacter.getStamina()+amount);
            System.out.println("Player stamina affected : " + amount);
        break;

        case "SKILL": playerCharacter.setSkill(playerCharacter.getSkill()+amount);
            System.out.println("Player skill affected : " + amount);
        break;

        case "LUCK" : playerCharacter.setLuck(playerCharacter.getLuck()+amount);
            System.out.println("Player luck affected : " + amount);
        break;
        }
    }
}
