package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockFrame extends JFrame {

    // initialize buttons
    private JButton confirmButton;
    private JButton backButton;

    public StockFrame() {
        super("Inventory Management System");                        // declare the JFrame and set title
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));     // declare new BoxLayout (see layout options here: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html)
        setSize(600, 500);                                    // set size of JFrame
        setVisible(true);                                                 // make the JFrame visible

        // declare buttons
        confirmButton = new JButton("Confirm");
        backButton = new JButton("Back to Main Menu");

        // add buttons to the JFrame
        add(confirmButton);
        add(backButton);

        confirmButton.addActionListener(new ActionListener() {             // add an action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {                   // when button is clicked
                                                                           //
            }
        });

        backButton.addActionListener(new ActionListener() {                // add an action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {                   // when button is clicked
                setVisible(false);                                         // hide the JFrame
            }
        });
    }


}
