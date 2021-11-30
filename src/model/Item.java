package model;

public class Item {

    private int itemCode;
    private String name;
    private double cost;
    private double price;
    private int numUnits;

    // constructor
    public Item(int itemCode, String name, double cost, double price, int numUnits) {
        this.itemCode = itemCode;
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.numUnits = numUnits;
    }

    // getter method for itemCode
    public int getItemCode() {
        return itemCode;
    }

    // setter method for itemCode
    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    // getter method for name
    public String getName() {
        return name;
    }

    // setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // getter method for cost
    public double getCost() {
        return cost;
    }

    // setter method for cost
    public void setCost(float cost) {
        this.cost = cost;
    }

    // getter method for price
    public double getPrice() {
        return price;
    }

    // setter method for price
    public void setPrice(float price) {
        this.price = price;
    }

    // getter method for numUnits
    public int getNumUnits() {
        return numUnits;
    }

    // setter method for numUnits
    public void setNumUnits(int numUnits) {
        this.numUnits = numUnits;
    }
}
