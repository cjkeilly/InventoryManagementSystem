package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    // initialize buttons
    private JButton stockButton;
    private JButton purchaseButton;
    private JButton saleButton;

    // constructor
    public MainFrame() {
        super("Inventory Management System");                        // declare the JFrame and set title
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));     // declare new BoxLayout (see layout options here: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html)
        setSize(600, 500);                                    // set size of JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                   // terminate program when x button is clicked
        setVisible(true);                                                 // make the JFrame visible

        // declare all buttons
        stockButton = new JButton("Opening Stock By Date");
        purchaseButton = new JButton("New Purchase");
        saleButton = new JButton("New Sale");

        // add all buttons to the JFrame
        add(stockButton);
        add(purchaseButton);
        add(saleButton);

        stockButton.addActionListener(new ActionListener() {             // add an action listener to the stock button
            @Override
            public void actionPerformed(ActionEvent e) {                 // when button is clicked
                new StockFrame();                                        // display stockFrame
            }
        });
    }

}
