package dD.gamehandlers;

import dD.dao.EventPool;
import dD.model.PlayerCharacter;
import javafx.event.ActionEvent;


import java.util.ArrayList;

public class GameEventHandler {

    private EventPool eventPool;
    private EventParser parser;

    public GameEventHandler() {
        eventPool = new EventPool();
        parser = new EventParser();
    }

    public void parseEventSequence(String eventSequence, PlayerCharacter p, ActionEvent e) {

        ArrayList<String> eventStrings = new ArrayList<>();

        if (eventSequence != null) {
            System.out.println("Checking sequence " + eventSequence);
            //Break event sequence into event ids
            String[] eventsIds = eventSequence.split(" ");

            //Uses event ids to get the event String from the database and composes a list of varying size.
            for (String a : eventsIds) {
                eventStrings.add(eventPool.getEvent(Integer.parseInt(a)));

            }

            //Run event description strings through parser.
            for (String event : eventStrings) {
                parser.parseGameEvents(event, p, e);
            }
        } else {
            System.out.println("Nothing to parse");
        }
    }
}
