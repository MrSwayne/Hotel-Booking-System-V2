package ie.ul.hbs2.GUI;

import ie.ul.hbs2.booking.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class BookingSummaryView {
    public void summary(String firstName, String lastName, String dateIn, String dateOut, String roomAmount,
                        String roomType, int BID, final double totalSpent)
    {
        JPanel mainPanel = new JPanel();
        JFrame frame = new JFrame("Booking Summary");


        mainPanel = new JPanel(new GridLayout(3,1));

        JLabel bookingID = new JLabel("Booking ID: ",JLabel.CENTER);
        JLabel bidLabel = new JLabel(String.valueOf(BID),JLabel.CENTER);

        JLabel fNameLabel = new JLabel("First Name: ",JLabel.CENTER);
        JLabel nameLabel = new JLabel(firstName,JLabel.CENTER);

        JLabel lNameLabel = new JLabel("Last Name: ",JLabel.CENTER);
        JLabel lastLabel = new JLabel(lastName,JLabel.CENTER);

        JLabel checkInDate = new JLabel("Check In Date: ",JLabel.CENTER);
        JLabel dateInLabel = new JLabel(dateIn,JLabel.CENTER);

        JLabel checkOutDate = new JLabel("Check Out Date ",JLabel.CENTER);
        JLabel dateOutLabel = new JLabel(dateOut,JLabel.CENTER);

        JLabel roomTotal = new JLabel("Room Total: ",JLabel.CENTER);
        JLabel roomAmountLabel = new JLabel(roomAmount,JLabel.CENTER);

        JLabel roomClass = new JLabel("Room Type: ",JLabel.CENTER);
        JLabel roomTypeLabel = new JLabel(roomType,JLabel.CENTER);

        final JLabel totalAmount = new JLabel("Total Amount: ",JLabel.CENTER);
        JLabel totalLabel = new JLabel(String.valueOf(totalSpent),JLabel.CENTER);

        //SubmitButton
        JPanel control = new JPanel();
        JButton submitBtn = new JButton("Submit");
        control.add(submitBtn);

        //CancelButton
        JButton cancelBtn = new JButton("Cancel");
        control.add(cancelBtn);

        final BookingSummaryView button = this;

        mainPanel.add(bookingID);
        mainPanel.add(bidLabel);
        mainPanel.add(fNameLabel);
        mainPanel.add(nameLabel);
        mainPanel.add(lNameLabel);
        mainPanel.add(lastLabel);
        mainPanel.add(checkInDate);
        mainPanel.add(dateInLabel);
        mainPanel.add(checkOutDate);
        mainPanel.add(dateOutLabel);
        mainPanel.add(roomTotal);
        mainPanel.add(roomAmountLabel);
        mainPanel.add(roomClass);
        mainPanel.add(roomTypeLabel);
        mainPanel.add(totalAmount);
        mainPanel.add(totalLabel);

        mainPanel.add(control);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);//setting to the center of the screen
        frame.setSize(1280, 720);

        frame.setVisible(true);


        //all the buttons you want to add.
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Code to call Adam's method in payment view
               // PaymentView.processPayment(totalSpent);
                System.out.println(totalSpent);

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