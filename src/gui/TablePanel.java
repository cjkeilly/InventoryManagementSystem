package gui;

import model.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TablePanel extends JPanel {
    private JTable table;
    private InventoryTableModel tableModel;

    public TablePanel() {
        tableModel = new InventoryTableModel();
        table = new JTable(tableModel);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(ArrayList<Item> db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
