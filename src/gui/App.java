package gui;

import javax.swing.*;

// main class which launches the application
public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        })
    }
}
