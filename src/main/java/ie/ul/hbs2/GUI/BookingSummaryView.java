package ie.ul.hbs2.GUI;

import ie.ul.hbs2.booking.*;
import ie.ul.hbs2.common.BackCommand;
import ie.ul.hbs2.common.Command;
import ie.ul.hbs2.common.DoNothingCommand;
import ie.ul.hbs2.common.SubmitCommand;
import ie.ul.hbs2.memento.CareTaker;
import ie.ul.hbs2.payments.IPaymentCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class BookingSummaryView extends View implements ActionListener {

    private IPaymentCallback callback;
    private static JTextArea roomsTypeList;
    JPanel mainPanel2 = new JPanel(new GridLayout(2, 1));
    private CommandJButton submitBtn;
    private CommandJButton cancelBtn;
    private double totalSpent;
    private Booking book;

    public BookingSummaryView(String name, Frame parent) {
        super(name, parent);
    }

    public void summary(Booking book, IPaymentCallback callback) {
        this.book = book;
        this.callback = callback;
        JPanel mainPanel = new JPanel(new GridLayout(4, 3));
        JPanel buttonPanel = new JPanel();
        //this.totalSpent = manager.calculateTotalSpent();
        submitBtn = new CommandJButton(new DoNothingCommand());
        cancelBtn = new CommandJButton(new DoNothingCommand());

        JLabel bookingID = new JLabel("Booking ID: ", JLabel.CENTER);
        JLabel bidLabel = new JLabel(String.valueOf(book.getBID()), JLabel.CENTER);

        JLabel fNameLabel = new JLabel("First Name: ", JLabel.CENTER);
        JLabel nameLabel = new JLabel(book.getFirstName(), JLabel.CENTER);

        JLabel lNameLabel = new JLabel("Last Name: ", JLabel.CENTER);
        JLabel lastLabel = new JLabel(book.getLastName(), JLabel.CENTER);

        JLabel checkInDate = new JLabel("Check In Date: ", JLabel.CENTER);
        JLabel dateInLabel = new JLabel(book.getDateIn(), JLabel.CENTER);

        JLabel checkOutDate = new JLabel("Check Out Date ", JLabel.CENTER);
        JLabel dateOutLabel = new JLabel(book.getDateOut(), JLabel.CENTER);

        JLabel roomTotal = new JLabel("Room Total: ", JLabel.CENTER);
        JLabel roomAmountLabel = new JLabel(String.valueOf(book.getRoomsType().length), JLabel.CENTER);

        JLabel roomClass = new JLabel("Room Type: ", JLabel.CENTER);
        getRoomsBooked(book.getRoomsType());

        final JLabel totalAmount = new JLabel("Total Amount: ", JLabel.CENTER);
        JLabel totalLabel = new JLabel(String.valueOf(book.getTotalSpent()), JLabel.CENTER);


        //SubmitButton
        JPanel control = new JPanel();
        submitBtn.setText("Submit");
        control.add(submitBtn);

        //CancelButton
        cancelBtn.setText("Cancel");
        control.add(cancelBtn);

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
        mainPanel2.add(roomClass,0);
        //mainPanel.add(roomTypeLabel);
        mainPanel.add(totalAmount);
        mainPanel.add(totalLabel);

        mainPanel.add(control);
        this.add(mainPanel,0);
        this.add(mainPanel2,1);

        //all the buttons you want to add.
        submitBtn.addActionListener(this);

        cancelBtn.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button == submitBtn) {
            System.out.println("Processing payment now");
            //Code to call Adam's method in payment view
            submitBtn.setCommand(new SubmitCommand(this.callback,book,parent));
            submitBtn.execute();

        } else if (button == cancelBtn) {
            cancelBtn.setCommand(new BackCommand(CareTaker.getInstance().get(1),parent));
            cancelBtn.execute();

        }
    }

    private void getRoomsBooked(Object[] roomsType) {
        String rmType = "";
        for (int i = 0; i < roomsType.length; i++) {
            roomsTypeList = new JTextArea();
            roomsTypeList.setText(roomsType[i].toString());
            roomsTypeList.setEditable(false);
            mainPanel2.add(roomsTypeList);
        }
    }
}
