package gui;

import model.Item;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InventoryTableModel extends AbstractTableModel {

    private ArrayList<Item> db = new ArrayList<Item>();
    private String[] colNames = {"Code", "Name", "Cost", "Price", "Stock"};

    public InventoryTableModel() {
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void setData(ArrayList<Item> db) {
        this.db = db;
    }


    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = db.get(rowIndex);

        switch(columnIndex) {
            case 0:
                return item.getItemCode();
            case 1:
                return item.getName();
            case 2:
                return item.getCost();
            case 3:
                return item.getPrice();
            case 4:
                return item.getNumUnits();
        }
        return null;
    }
}
