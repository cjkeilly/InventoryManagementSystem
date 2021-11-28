package model;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<Item> openingStock;
    private ArrayList<Item> currentStock;
    private ArrayList<Purchase> purchases;
    private ArrayList<Sale> sales;
    private Connection con;

    public void connect() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }

        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/InventoryManagementSystem";
        con = DriverManager.getConnection(connectionUrl, "cjkeilly", "Grandflower362");

        System.out.println("Connected: " + con);

    }

    public void disconnect() {

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection...");
            }
        }

    }

    public void save() {

        String checkSQL = "SELECT COUNT(*) FROM inventory WHERE item_code=?";
        try {
            PreparedStatement checkStatement = con.prepareStatement(checkSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // getter method for openingStock
    public ArrayList<Item> getOpeningStock() {
        return openingStock;
    }

    // getter method for currentStock
    public ArrayList<Item> getCurrentStock() {
        return currentStock;
    }

    // adds new purchase to ArrayList of purchases for that day
    public void newPurchase(Purchase newPurchase) {
        purchases.add(newPurchase);
    }

    // adds new sale to ArrayList of sales for that day
    public void newSale(Sale newSale) {
        sales.add(newSale);
    }

}
