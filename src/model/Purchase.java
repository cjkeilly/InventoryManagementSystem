package model;

public class Purchase {
	
    private Item item;
    private int numUnits;
    private Connection con;
    private double tax;
    private double pricePerUnit;
    private double taxCost;
    
    
    private  ArrayList<Purchase> purchases;
    
    // method for calculating tax
    public void calculateTax(double tax, double pricePerUnit, int numUnits) {
		double taxCost = (pricePerUnit * numUnits) * tax;
	}
	
    // method for calculating the total, after tax
	public void calculateTotal(double pricePerUnit, double taxCost, int numUnits) {
		double total = (pricePerUnit * numUnits) + taxCost;
	}
	
	

	// getter method for selectedItem
	public void getSelectedItem() {
		return selectedItem;
	}
	
	// setter method for selectedItems
	public void setSelectedItems(Item selectedItem) {
		this.selectedItem = selectedItem;
	}

}
