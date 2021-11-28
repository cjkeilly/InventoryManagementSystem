package gui;

// import necessary packages/libraries
import controller.DateLabelFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class InventoryFrame extends JFrame {

    private JLabel calendarLabel;
    private JButton backButton;

    public InventoryFrame() {
        super("Stock Menu");                                         // declare the JFrame and set title
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));     // declare new BoxLayout (see layout options here: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html)
        setSize(600, 500);                                    // set size of JFrame
        setVisible(true);                                                 // make the JFrame visible

        calendarLabel = new JLabel("Select a date below");
        backButton = new JButton("Main Menu");

        // create new JDatePicker (code found at https://stackoverflow.com/questions/26794698/how-do-i-implement-jdatepicker)
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // add calendar and its label to the JFrame
        add(calendarLabel);
        add(datePicker);

        // add buttons to the JFrame
        add(backButton);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
