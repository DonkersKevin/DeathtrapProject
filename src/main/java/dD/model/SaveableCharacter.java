package dD.model;

import javafx.beans.property.IntegerProperty;

import java.io.Serializable;
import java.util.List;

public class SaveableCharacter implements Serializable {


    private int maxStamina;
    private int maxSkill;
    private int maxLuck;

    private int stamina;
    private int skill;
    private int luck;

    private int initialStam;
    private int initialSkill;
    private int initialLuck;

    private int provisions;
    private int potionUses;
    private String potionChoice;

    private SaveableInventory inventory;
    private List<String> eventList;

    private int currentLocationID;


    public SaveableCharacter(String name, int maxStamina, int maxSkill, int maxLuck, int stamina, int skill, int luck, int initialStam, int initialSkill, int initialLuck, int provisions, int potionUses, String potionChoice, SaveableInventory inventory, List<String> eventList, int currentLocationID) {
        this.name = name;

        this.maxStamina = maxStamina;
        this.maxSkill = maxSkill;
        this.maxLuck = maxLuck;

        this.stamina = stamina;
        this.skill = skill;
        this.luck = luck;

        this.initialStam = initialStam;
        this.initialSkill = initialSkill;
        this.initialLuck = initialLuck;

        this.provisions = provisions;
        this.potionUses = potionUses;
        this.potionChoice = potionChoice;

        this.inventory = inventory;

        this.eventList = eventList;

        this.currentLocationID = currentLocationID;
    }


    private String name;

    public String getName() {
        return name;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public int getMaxSkill() {
        return maxSkill;
    }

    public int getMaxLuck() {
        return maxLuck;
    }

    public int getStamina() {
        return stamina;
    }

    public int getSkill() {
        return skill;
    }

    public int getLuck() {
        return luck;
    }

    public int getInitialStam() {
        return initialStam;
    }

    public int getInitialSkill() {
        return initialSkill;
    }

    public int getInitialLuck() {
        return initialLuck;
    }

    public int getProvisions() {
        return provisions;
    }

    public int getPotionUses() {
        return potionUses;
    }

    public String getPotionChoice() {
        return potionChoice;
    }

    public SaveableInventory getInventory() {
        return inventory;
    }

    public List<String> getEventList() {
        return eventList;
    }

    public int getCurrentLocationID() {
        return currentLocationID;
    }
}
