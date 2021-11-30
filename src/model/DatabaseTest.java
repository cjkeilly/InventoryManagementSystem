package model;// import necessary packages/libraries
import model.Database;

import java.sql.SQLException;

// tests the connection to the MySQL database
public class DatabaseTest {

    public static void main(String[] args) throws SQLException {
        System.out.println("Running database test...");

        // try to connect to the database, throw exception if unsuccessful
        Database db = new Database();
        try {
            db.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        db.addItem(new Item(8, "TestItem2", 0.54, 2.50, 25));
        db.saveInventory();

        db.load();

        db.disconnect();
    }

}
