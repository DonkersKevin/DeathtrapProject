package dD.model;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SaveableInventory implements Serializable {

    private ArrayList<String> inventoryList;

    public ArrayList<String> getInventoryList() {
        return inventoryList;
    }

    public SaveableInventory(ArrayList<String> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public SaveableInventory(Inventory inventory) {
        this.inventoryList = new ArrayList<String>(inventory.getInventoryList());
    }
}
