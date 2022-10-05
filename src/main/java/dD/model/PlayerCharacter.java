package dD.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter {

    private String name;

    private int maxStamina;
    private int maxSkill;
    private int maxLuck;

    private int initialStam;
    private int initialSkill;
    private int initialLuck;

    private String potionChoice;

    private Inventory inventory;
    private List<String> eventList;


    //Listeners
    private IntegerProperty stamina;
    private IntegerProperty skill;
    private IntegerProperty luck;
    private IntegerProperty provisions;
    private IntegerProperty potionUses;


    public PlayerCharacter(String name, int stamina, int skill, int luck, String potionChoice, int provisions) {
        this.name = name;
        this.stamina = new SimpleIntegerProperty(this, "Stamina", stamina);
        this.skill = new SimpleIntegerProperty(this, "Skill", skill);
        this.luck = new SimpleIntegerProperty(this, "Luck", luck);

        this.provisions = new SimpleIntegerProperty(this, "Provisions", provisions);
        this.potionUses = new SimpleIntegerProperty(this, "PotionUses", 2);
        this.potionChoice = potionChoice;

        this.inventory = new Inventory();
        this.eventList = new ArrayList<String>();

        maxLuck = luck;
        maxSkill = skill;
        maxStamina = stamina;

        initialLuck = luck;
        initialSkill = skill;
        initialStam = stamina;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public int getMaxSkill() {
        return maxSkill;
    }

    public void setMaxSkill(int maxSkill) {
        this.maxSkill = maxSkill;
    }

    public int getMaxLuck() {
        return maxLuck;
    }

    public void setMaxLuck(int maxLuck) {
        this.maxLuck = maxLuck;
    }

    public int getInitialStam() {
        return initialStam;
    }

    public void setInitialStam(int initialStam) {
        this.initialStam = initialStam;
    }

    public int getInitialSkill() {
        return initialSkill;
    }

    public void setInitialSkill(int initialSkill) {
        this.initialSkill = initialSkill;
    }

    public int getInitialLuck() {
        return initialLuck;
    }

    public void setInitialLuck(int initialLuck) {
        this.initialLuck = initialLuck;
    }

    public String getPotionChoice() {
        return potionChoice;
    }

    public void setPotionChoice(String potionChoice) {
        this.potionChoice = potionChoice;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<String> getEventList() {
        return eventList;
    }

    public void setEventList(List<String> eventList) {
        this.eventList = eventList;
    }

    public int getStamina() {
        return stamina.get();
    }

    public IntegerProperty staminaProperty() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina.set(stamina);
    }

    public int getSkill() {
        return skill.get();
    }

    public IntegerProperty skillProperty() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill.set(skill);
    }

    public int getLuck() {
        return luck.get();
    }

    public IntegerProperty luckProperty() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck.set(luck);
    }

    public int getProvisions() {
        return provisions.get();
    }

    public IntegerProperty provisionsProperty() {
        return provisions;
    }

    public void setProvisions(int provisions) {
        this.provisions.set(provisions);
    }

    public int getPotionUses() {
        return potionUses.get();
    }

    public IntegerProperty potionUsesProperty() {
        return potionUses;
    }

    public void setPotionUses(int potionUses) {
        this.potionUses.set(potionUses);
    }

    public void eat() {
        /*        this.provisions -= 1;*/
/*        if((stamina+4)<=maxStamina){
            stamina=stamina+4;
        }else{
            stamina=maxStamina;
        }*/
    }

    public boolean drinkPotion(String type) {
        if (type.equals("SKILL")) {
            if (skill.intValue() == maxSkill) {
                return false;
            } else {
                System.out.println("Drinking skill potion.");
                setSkill(initialSkill);
                return true;
            }
        }

        if (type.equals("STAMINA")) {
            if (stamina.intValue() == maxStamina) {
                return false;
            } else {
                System.out.println("Drinking stamina potion.");
                setStamina(initialStam);
                return true;
            }
        }

        if (type.equals("LUCK")) {
            if (luck.intValue() == maxLuck) {
                return false;
            } else {
                System.out.println("Drinking luck potion.");
                initialLuck++;
                setLuck(initialLuck);
                return true;
            }
        }
        return false;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void addToInventory(String item) {
        inventory.addItem(item);
        System.out.println("Item added to inventory : " + item);
    }

    public boolean checkInventory(String item) {
        return inventory.checkInventoryForItem(item);
    }

    public void removeFromInventory(String item) {
        if (checkInventory(item)) {
            inventory.removeItem(item);
            System.out.println("Removed " + item + " from inventory.");
        } else {
            System.out.println("No such item found in inventory");
        }
    }

    public void addToEventList(String event) {
        eventList.add(event);
        System.out.println("Event " + event + " added to eventlist");
    }

    public boolean checkEventList(String event) {
        for (String listitem : eventList) {
            if (event.equals(listitem)) {
                return true;
            }
        }
        return false;
    }

    public void removeFromEventList(String event) {
        eventList.remove(event);
        System.out.println("Event " + event + " removed from eventlist");
    }

    public void printInventory() {
        System.out.println(this.inventory);
    }


}
