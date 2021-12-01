package gui;

// import necessary packages/libraries
import com.mysql.cj.xdevapi.Table;
import controller.Controller;
import model.Database;
import model.Item;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Properties;

public class InventoryFrame extends JFrame {

    private TablePanel tablePanel;
    private Database db;
    private JButton refreshButton;
    private JButton backButton;

    public InventoryFrame() {
        super("Stock Menu");                                             // declare the JFrame and set title
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));        // declare new BoxLayout (see layout options here: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html)
        setSize(600, 500);                                       // set size of JFrame
        setVisible(true);                                                    // make the JFrame visible

        tablePanel = new TablePanel();
        db = new Database();
        refreshButton = new JButton("Refresh");
        backButton = new JButton("Main Menu");

        Controller controller = new Controller();
        tablePanel.setData(controller.getInventory());

        add(tablePanel, BorderLayout.CENTER);

        // add buttons to the JFrame
        add(refreshButton);
        add(backButton);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.refresh();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
