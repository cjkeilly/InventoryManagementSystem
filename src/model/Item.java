package model;

public class Item {

    private int itemCode;
    private String name;
    private float pricePerUnit;
    private int numUnits;

    // constructor
    public Item(int itemCode, String name, float pricePerUnit, int numUnits) {
        this.itemCode = itemCode;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
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

    // getter method for pricePerUnit
    public float getPricePerUnit() {
        return pricePerUnit;
    }

    // setter method for pricePerUnit
    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
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
