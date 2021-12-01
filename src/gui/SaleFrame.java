package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SaleFrame extends JFrame {
	
	private JLabel itemCodeLabel;
	private JTextField itemCodeField;
	private JLabel unitsPurchasedLabel;
	private JTextField unitsPurchasedField;
	private JLabel itemNameLabel;
	private JTextField itemNameField;
	private JLabel pricePerUnitLabel;
	private JTextField pricePerUnitField;
	private JLabel customerFirstName;
	private JTextField customerFirstField;
	private JLabel customerLastName;
	private JTextField customerLastField;
	private JLabel customerEmailLabel;
	private JTextField customerEmailField;

	// initialize text areas and their labels
	private JLabel totalLabel;
	private JTextArea totalTextArea;

	// initialize buttons
	private JButton confirmButton;
	private JButton backButton;
	
	public SaleFrame() {
		super("Sale Menu");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));     // declare new BoxLayout (see layout options here: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html)
	    setSize(600, 500);                                    // set size of JFrame
	    setVisible(true);   
	    
	    //declare text fields and their labels
	    itemCodeLabel = new JLabel("Item Code: ");
	    itemCodeField = new JTextField();
	    unitsPurchasedLabel = new JLabel("Number of Units Sold: ");
        unitsPurchasedField = new JTextField();
        itemNameLabel = new JLabel("Item Name: ");
        itemNameField = new JTextField();
        pricePerUnitLabel = new JLabel("Price Per Unit: ");
        pricePerUnitField = new JTextField();
        customerFirstName = new JLabel("Customer's First Name: ");
        customerFirstField = new JTextField();
        customerLastName = new JLabel("Customer's Last Name: ");
        customerLastField = new JTextField();
        customerEmailLabel = new JLabel("Customer's Email: ");
        customerEmailField = new JTextField();
        
     // declare text areas and their labels
        totalLabel = new JLabel("Total: ");
        totalTextArea = new JTextArea();

        // declare buttons
        confirmButton = new JButton("Confirm");
        backButton = new JButton("Back to Main Menu");
        
     // add text fields and their labels to the JFrame
        add(itemCodeLabel);
        add(itemCodeField);
        add(unitsPurchasedLabel);
        add(unitsPurchasedField);
        add(itemNameLabel);
        add(itemNameField);
        add(pricePerUnitLabel);
        add(pricePerUnitField);
        add(customerFirstName);
        add(customerFirstField);
        add(customerLastName);
        add(customerLastField);
        add(customerEmailLabel);
        add(customerEmailField);
        
        // add text areas and their labels to the JFrame
        add(totalLabel);
        add(totalTextArea);

        // add buttons to the JFrame
        add(confirmButton);
        add(backButton);
        
        confirmButton.addActionListener(new ActionListener() {                       // add an action listener to the confirm button
            @Override
            public void actionPerformed(ActionEvent e) {                             // when button is clicked
                int itemCode = Integer.parseInt(itemCodeField.getText());
                int unitsPurchased = Integer.parseInt(itemNameField.getText());
                String name = itemNameField.getText();

            }
        }
        );

        backButton.addActionListener(new ActionListener() {                // add an action listener to the back button
            @Override
            public void actionPerformed(ActionEvent e) {                   // when button is clicked
                dispose();                                                 // hide the JFrame
            }
        }
        );
	}
}
