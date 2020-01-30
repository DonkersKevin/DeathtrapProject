package dD.model;

import java.util.Random;

public class Die {

    private Random rand;

    public Die() {
        this.rand = new Random();
    }

    public int rollOneDie(){
        return rand.nextInt(6)+1;
    }

    public int rollTwoDice(){
        return (rand.nextInt(6)+1) + (rand.nextInt(6)+1);
    }
}
