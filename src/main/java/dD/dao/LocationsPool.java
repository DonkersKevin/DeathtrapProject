package dD.dao;

import dD.model.Location;

import java.sql.*;

public class LocationsPool {

    public static final String DB_NAME = "dDungeon.db";
    public static final String CONN_STRING = "jdbc:sqlite::resource:Database/" + DB_NAME;

    public static final String TABLE_LOCATIONS = "locations";


    public Location getLocation(int index){
        try(Connection con = DriverManager.getConnection(CONN_STRING);
            Statement stat = con.createStatement()) {


            ResultSet set = stat.executeQuery("SELECT * FROM " + TABLE_LOCATIONS + " WHERE locationID = " + index);

            Location loc = new Location();

            while (set.next()){
                loc.setLocationID(set.getInt("locationID"));
                loc.setDescription(set.getString("description"));

                loc.addExit("a",set.getInt("a"));
                loc.addExitDescription("a",set.getString("aDesc"));

                loc.addExit("b",set.getInt("b"));
                loc.addExitDescription("b",set.getString("bDesc"));

                loc.addExit("c",set.getInt("c"));
                loc.addExitDescription("c",set.getString("cDesc"));

                loc.addExit("d",set.getInt("d"));
                loc.addExitDescription("d",set.getString("dDesc"));

                loc.addExit("e",set.getInt("e"));
                loc.addExitDescription("e",set.getString("eDesc"));

                loc.addExit("f",set.getInt("f"));
                loc.addExitDescription("f",set.getString("fDesc"));

                loc.setEventSequence(set.getString("eventSequence"));
            }
            return loc;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
