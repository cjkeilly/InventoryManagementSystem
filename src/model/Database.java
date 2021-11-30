package model;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<Item> inventory = new ArrayList<Item>();
    private ArrayList<Purchase> purchases = new ArrayList<Purchase>();
    private ArrayList<Sale> sales = new ArrayList<Sale>();
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

    /* saves the contents of the local inventory stored in ArrayList inventory to the MySQL database
       first, checks if the item is in the database
       if it is, update the item's attributes
       if it is not, add the item to the inventory table
     */
    public void saveInventory() {

        // SQL statement to check if the item is in the MySQL database (returns 1 if yes, 0 if no)
        String checkSQL = "SELECT COUNT(*) FROM inventory WHERE item_code=?";

        // SQL statement to insert an item into the inventory in the case that it is not in the MySQL database
        String insertSQL = "INSERT INTO inventory (item_code, name, cost, price, numUnits) VALUES (?, ?, ?, ?, ?)";

        // SQL statement to update an existing item in the inventory
        String updateSQL = "UPDATE inventory SET item_code=?, name=?, cost=?, price=?, numUnits=? WHERE item_code=?";

        try {
            PreparedStatement checkStatement = con.prepareStatement(checkSQL);
            PreparedStatement insertStatement = con.prepareStatement(insertSQL);
            PreparedStatement updateStatement = con.prepareStatement(updateSQL);

            for (Item item : inventory) {

                // get attributes for the item
                int itemCode = item.getItemCode();
                String name = item.getName();
                double cost = item.getCost();
                double price = item.getPrice();
                int numUnits = item.getNumUnits();

                //  insert itemCode into checkStatement wild card (it is the first wild card)
                checkStatement.setInt(1, itemCode);

                // execute the checkStatement and store the result
                ResultSet checkResult = checkStatement.executeQuery();
                checkResult.next();

                // store the value of the result
                int count = checkResult.getInt(1);

                if (count == 0) {
                    System.out.println("Inserting item with code " + itemCode);

                    int col = 1;
                    insertStatement.setInt(col++, itemCode);
                    insertStatement.setString(col++, name);
                    insertStatement.setDouble(col++, cost);
                    insertStatement.setDouble(col++, price);
                    insertStatement.setInt(col++, numUnits);

                    insertStatement.executeUpdate();
                } else {
                    System.out.println("Updating item with code " + itemCode);

                    int col = 1;
                    updateStatement.setInt(col++, itemCode);
                    updateStatement.setString(col++, name);
                    updateStatement.setDouble(col++, cost);
                    updateStatement.setDouble(col++, price);
                    updateStatement.setInt(col++, numUnits);
                    updateStatement.setInt(col++, itemCode);

                    updateStatement.executeUpdate();
                }

            }

            updateStatement.close();
            insertStatement.close();
            checkStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void load() throws SQLException {
        inventory.clear();

        String sql = "SELECT item_code, name, cost, price, numUnits FROM inventory ORDER BY item_code";
        Statement selectStatement = con.createStatement();

        ResultSet results = selectStatement.executeQuery(sql);

        while (results.next()) {
            int itemCode = results.getInt("item_code");
            String name = results.getString("name");
            double cost = results.getDouble("cost");
            double price = results.getDouble("price");
            int numUnits = results.getInt("numUnits");

            inventory.add(new Item(itemCode, name, cost, price, numUnits));
        }

        results.close();
        selectStatement.close();
    }

    // getter method for openingStock
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // adds item to ArrayList of inventory
    public void addItem(Item newItem) {
        inventory.add(newItem);
    }

    // adds new purchase to ArrayList of purchases
    public void newPurchase(Purchase newPurchase) {
        purchases.add(newPurchase);
    }

    // adds new sale to ArrayList of sales
    public void newSale(Sale newSale) {
        sales.add(newSale);
    }

}
