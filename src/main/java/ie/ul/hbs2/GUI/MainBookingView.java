package ie.ul.hbs2.GUI;

import ie.ul.hbs2.booking.BackCommand;
import ie.ul.hbs2.booking.Booking;
import ie.ul.hbs2.booking.Command;
import ie.ul.hbs2.booking.NextCommand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

public class MainBookingView extends View {
    public JTextArea textField;
    public String clipboard;

    //Booking View and Cancel View buttons and text fields
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField dateInField;
    private JTextField dateOutField;
    private JTextField roomsBooked;
    private JTextField type;
    private JButton submitBtn;
    private JButton cancelBtn;
    private JButton nextBtn;
    private JButton backBtn;
    private JTextField cancelField;

    public MainBookingView(String name, Frame parent) {
        super(name, parent);

        JPanel mainPanel = new JPanel();

        // Label and Field
        JPanel fName = new JPanel();
        JLabel fnameLabel = new JLabel("First Name: ",JLabel.CENTER);
        fnameField = new JTextField("",10);
        fName.add(fnameLabel);
        fName.add(fnameField);

        // Label and Field
        JPanel lName = new JPanel();
        JLabel lnameLabel = new JLabel("Last Name: ",JLabel.CENTER);
        lnameField = new JTextField("",10);
        lName.add(lnameLabel);
        lName.add(lnameField);

        // Label and Field
        JPanel dateInPanel = new JPanel();
        JLabel dateInLabel = new JLabel("Date in: ",JLabel.CENTER);
        dateInField = new JTextField("",10);
        dateInPanel.add(dateInLabel);
        dateInPanel.add(dateInField);

        // Label and Field
        JPanel dateOutPanel = new JPanel();
        JLabel dateOutLabel = new JLabel("Date out: ",JLabel.CENTER);
        dateOutField = new JTextField("",10);
        dateOutPanel.add(dateOutLabel);
        dateOutPanel.add(dateOutField);

        // Label and Field
        JPanel roomsPanel = new JPanel();
        JLabel roomLabel = new JLabel("Rooms: ",JLabel.CENTER);
        roomsBooked= new JTextField("",10);
        roomsPanel.add(roomLabel);
        roomsPanel.add(roomsBooked);

        // Label and Field
        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Type: ",JLabel.CENTER);
        type = new JTextField("",10);
        typePanel.setVisible(true);
        typePanel.add(typeLabel);
        typePanel.add(type);

        // Label and Field
        JPanel cancelID = new JPanel();
        JLabel cancelLabel = new JLabel("Booking ID: ",JLabel.CENTER);
        cancelField = new JTextField("",10);
        cancelID.add(cancelLabel);
        cancelID.add(cancelField);

        //nextButton
        JPanel control = new JPanel();
        nextBtn = new JButton("Next");
        control.add(nextBtn);

        //backButton
        backBtn = new JButton("Back");
        control.add(backBtn);

        //Adding to main panel
        mainPanel.add(fName);
        mainPanel.add(lName);
        mainPanel.add(dateInPanel);
        mainPanel.add(dateOutPanel);
        mainPanel.add(typePanel);
        mainPanel.add(roomsPanel);
        mainPanel.add(cancelID);
        mainPanel.add(control);

        this.add(mainPanel);

        final MainBookingView button = this;


        //all the buttons you want to add.
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Booking book = new Booking();

                if(book.checkBooking(getFirstName(),getLastName(),getDateIn(),getDateOut(),
                        getRoomAmount(),getRoomType()))
                {
                    executeCommand(new NextCommand(button));

                }
                else{
                    //do something
                    System.out.println("Error");
                }
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new BackCommand(button));
            }
        });

    }

    private void executeCommand(Command command) {
        command.execute();
    }

    public String getFirstName() {
        return fnameField.getText();
    }
    public String getLastName() {
        return lnameField.getText();
    }
    public String getDateIn() {
        return dateInField.getText();
    }
    public String getDateOut() {
        return dateOutField.getText();
    }
    public String getRoomType() {
        return type.getText();
    }
    public String getRoomAmount() {
        return roomsBooked.getText();
    }

    @Override
    public void setMessage(String message) {

    }
}


