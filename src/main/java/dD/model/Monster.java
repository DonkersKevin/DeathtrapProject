package dD.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Monster {

    private String name;
    private int skill;

    private IntegerProperty stamina;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public Monster(String name, int stamina, int skill) {
        this.name = name;
        this.stamina = new SimpleIntegerProperty(this, "Stamina", stamina);
        this.skill = skill;
    }
}
