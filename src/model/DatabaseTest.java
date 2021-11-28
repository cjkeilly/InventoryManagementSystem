package model;// import necessary packages/libraries
import model.Database;

// tests the connection to the MySQL database
public class DatabaseTest {

    public static void main(String[] args) {
        System.out.println("Running database test...");

        // try to connect to the database, throw exception if unsuccessful
        Database db = new Database();
        try {
            db.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
    }

}
