package gui;

// import necessary packages/libraries
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// creates main menu of the application
public class MainFrame extends JFrame {

    // initialize buttons
    private JButton inventoryButton;
    private JButton purchaseButton;
    private JButton saleButton;

    // constructor
    public MainFrame() {
        super("Inventory Management System");                           // declare the JFrame and set title
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));       // declare new BoxLayout (see layout options here: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html)
        setSize(600, 500);                                      // set size of JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                     // terminate program when x button is clicked
        setVisible(true);                                                   // make the JFrame visible

        // declare all buttons
        inventoryButton = new JButton("Inventory");
        purchaseButton = new JButton("New Purchase");
        saleButton = new JButton("New Sale");

        // add all buttons to the JFrame
        add(inventoryButton);
        add(purchaseButton);
        add(saleButton);

        inventoryButton.addActionListener(new ActionListener() {            // add an action listener to the inventory button
            @Override
            public void actionPerformed(ActionEvent e) {                    // when button is clicked
                new InventoryFrame();                                       // display InventoryFrame
            }
        });

        purchaseButton.addActionListener(new ActionListener() {             // add an action listener to the purchase button
            @Override
            public void actionPerformed(ActionEvent e) {                    // when button is clicked
                new PurchaseFrame();                                        // display PurchaseFrame
            }
        });
    }

}
