package dD.gamehandlers;

import dD.model.Die;

public class DiceTestHandler {

    private Die die;

    public DiceTestHandler() {
        this.die = new Die();
    }

    public boolean testYourLuck(int playerLuck) {
        if (die.rollTwoDice() <= playerLuck) {
            return true;
        }
        return false;
    }

    public boolean testYourSkill(int playerSkill) {
        if (die.rollTwoDice() <= playerSkill) {
            return true;
        }
        return false;
    }

    public boolean testYourStamAndSkill(int playerStamina, int playerSkill) {
        int roll = die.rollTwoDice();
        if (roll <= playerSkill && roll <= playerStamina) {
            return true;
        }
        return false;
    }


    public boolean testYourRoll8() {
        if (die.rollTwoDice() <= 8) {
            return true;
        }
        return false;
    }

    public int testYourRollRange() {
        int roll = die.rollOneDie();
        if (roll < 3) {
            return 1;
        } else if (roll > 4) {
            return 3;
        } else
            return 2;
    }
}
