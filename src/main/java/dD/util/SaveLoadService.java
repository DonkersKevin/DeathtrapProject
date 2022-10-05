package dD.util;

import dD.model.*;
import javafx.collections.FXCollections;

import java.io.*;
import java.nio.file.Files;

import static dD.controllers.MainController.playerCharacter;

public class SaveLoadService {

    public void save(PlayerCharacter p, Location l) {

        SaveableInventory saveInv = new SaveableInventory(p.getInventory());
        SaveableCharacter saveChar = new SaveableCharacter(p.getName(), p.getMaxStamina(), p.getMaxSkill(), p.getMaxLuck(), p.getStamina(), p.getSkill(), p.getLuck(), p.getInitialStam(), p.getInitialSkill(), p.getInitialLuck(), p.getProvisions(), p.getPotionUses(), p.getPotionChoice(), saveInv, p.getEventList(), l.getLocationID());

        try {
            /*                FileOutputStream fileOut = new FileOutputStream(new File(".\\sav\\" + p.getName().replaceAll(" ", "") + l.getLocationID() + ".sav").getCanonicalFile());*/
            FileOutputStream fileOut = new FileOutputStream(new File(".\\sav\\Save1.sav").getCanonicalFile());


            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(saveChar);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /sav/");

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public SaveableCharacter load(String saveName) {

        try {
            FileInputStream in = new FileInputStream(new File(".\\sav\\Save1.sav").getCanonicalFile());
            ObjectInputStream ois = new ObjectInputStream(in);
            SaveableCharacter loadChar = (SaveableCharacter) ois.readObject();
            updateCurrentPlayer(loadChar);


            in.close();
            ois.close();

            return loadChar;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void updateCurrentPlayer(SaveableCharacter sav) {
        playerCharacter.setName(sav.getName());
        playerCharacter.setStamina(sav.getStamina());
        playerCharacter.setSkill(sav.getSkill());
        playerCharacter.setLuck(sav.getLuck());

        playerCharacter.setInitialLuck(sav.getInitialLuck());
        playerCharacter.setInitialSkill(sav.getInitialSkill());
        playerCharacter.setInitialStam(sav.getInitialStam());

        playerCharacter.setMaxLuck(sav.getMaxLuck());
        playerCharacter.setMaxSkill(sav.getMaxSkill());
        playerCharacter.setMaxStamina(sav.getMaxStamina());

        playerCharacter.setPotionUses(sav.getPotionUses());
        playerCharacter.setPotionChoice(sav.getPotionChoice());

        playerCharacter.setProvisions(sav.getProvisions());

        playerCharacter.setEventList(sav.getEventList());
        Inventory inv = new Inventory(sav.getInventory());
        playerCharacter.setInventory(inv);

    }

}
