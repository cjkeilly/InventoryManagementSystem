package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MainMenu extends javax.swing.JFrame {
    private JButton OpeningStockByDate;
    private JPanel panel1;


    // closes the window - we call this function when a button is pressed
    // code taken from tutorial https://www.youtube.com/watch?v=ZD6626aW54M&list=PLD6c6iED3skhfYoHw-Px-LFUSutfo0iQ3&index=19
    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public MainMenu() {
        OpeningStockByDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                OpeningStockByDate openingStock = new OpeningStockByDate();
                openingStock.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("IMS");
        frame.setContentPane(new MainMenu().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
