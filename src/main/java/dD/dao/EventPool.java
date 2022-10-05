package dD.dao;

import java.sql.*;

public class EventPool {

    public static final String DB_NAME = "dDungeon.db";
    public static final String CONN_STRING = "jdbc:sqlite::resource:Database/" + DB_NAME;

    public static final String TABLE_EVENTS = "events";
    public static final String COLUMN_EVENT_STRING = "eventstring";


    public String getEvent(int index) {
        try (Connection con = DriverManager.getConnection(CONN_STRING);
             Statement stat = con.createStatement()) {


            ResultSet set = stat.executeQuery("SELECT " + COLUMN_EVENT_STRING + " FROM " + TABLE_EVENTS + " WHERE id = " + index);

            String eventString = set.getString("eventstring");
            return eventString;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
