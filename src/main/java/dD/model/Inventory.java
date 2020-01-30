package dD.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Serializable {

    private ObservableList<String> inventoryList;


    public Inventory() {
        this.inventoryList = FXCollections.observableArrayList();
    }

    public Inventory (SaveableInventory inv){
        this.inventoryList = FXCollections.observableArrayList();
        inventoryList.addAll(inv.getInventoryList());
    }

    public List<String> getInventoryList() {
        return inventoryList;
    }

    public void addItem(String item){
        inventoryList.add(item);
    }

    public void removeItem(String item){
        inventoryList.remove(item);
    }

    public boolean checkInventoryForItem(String item){
        if(inventoryList.contains(item)){
            return true;
        }else{
            return false;
        }
    }
}
