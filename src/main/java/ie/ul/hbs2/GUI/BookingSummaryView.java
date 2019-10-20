package ie.ul.hbs2.GUI;

import ie.ul.hbs2.booking.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingSummaryView {
    public void summary(String firstName, String lastName, String dateIn, String dateOut, String roomAmount,
                        String roomType, int BID, double totalSpent)
    {
        JPanel mainPanel = new JPanel();
        JFrame frame = new JFrame("Booking Summary");

        mainPanel = new JPanel(new GridLayout(3,1));

        JLabel bidLabel = new JLabel(String.valueOf(BID),JLabel.CENTER);
        JLabel nameLabel = new JLabel(firstName,JLabel.CENTER);
        JLabel lastLabel = new JLabel(lastName,JLabel.CENTER);
        JLabel dateInLabel = new JLabel(dateIn,JLabel.CENTER);
        JLabel dateOutLabel = new JLabel(dateOut,JLabel.CENTER);
        JLabel roomAmountLabel = new JLabel(roomAmount,JLabel.CENTER);
        JLabel roomTypeLabel = new JLabel(roomType,JLabel.CENTER);
        JLabel totalLabel = new JLabel(String.valueOf(totalSpent),JLabel.CENTER);

        //SubmitButton
        JPanel control = new JPanel();
        JButton submitBtn = new JButton("Submit");
        control.add(submitBtn);

        //CancelButton
        JButton cancelBtn = new JButton("Cancel");
        control.add(cancelBtn);

        final BookingSummaryView button = this;

        mainPanel.add(bidLabel);
        mainPanel.add(nameLabel);
        mainPanel.add(lastLabel);
        mainPanel.add(dateInLabel);
        mainPanel.add(dateOutLabel);
        mainPanel.add(roomAmountLabel);
        mainPanel.add(roomTypeLabel);
        mainPanel.add(totalLabel);
        mainPanel.add(control);

        frame.add(mainPanel);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //all the buttons you want to add.
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    executeCommand(new SubmitCommand(button));
                }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CancelCommand(button));
            }
        });

    }
    private void executeCommand(CommandSummary command) {
        command.execute();
    }
}
