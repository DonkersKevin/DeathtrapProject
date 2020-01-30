package dD.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Location implements Serializable {

    private int locationID;
    private String description;
    private String eventSequence;
    private Map<String, Integer> exits;
    private Map<String, String> exitDescription;

    public Location() {
        this.exits = new HashMap<String, Integer>();
        this.exitDescription = new HashMap<String, String>();
    }

    public Location(int locationID, String description, String eventSequence) {
        super();
        this.eventSequence = eventSequence;
        this.locationID = locationID;
        this.description = description;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventSequence() {
        return eventSequence;
    }

    public void setEventSequence(String eventSequence) {
        this.eventSequence = eventSequence;
    }

    public void addExit(String key, int value){
        exits.put(key,value);
    }

    public void addExitDescription(String key, String value){
        exitDescription.put(key,value);
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    public Map<String, String> getExitDescription(){
        if(exitDescription!=null){
            return new HashMap<String, String>(exitDescription);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", description='" + description + '\'' +
                ", exits=" + exits +
                '}';
    }
}
