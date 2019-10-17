package ie.ul.hbs2.booking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainBookingView {
    private JButton Reservation;
    private JButton CancelReservation;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField dateInField;
    private JTextField dateOutField;
    private JTextField roomsBooked;
    private JTextField type;
    private JButton nextBtn;
    private JButton backBtn;
    public MainBookingView()
    {
        JFrame frame = new JFrame("Booking Main Menu");
        JPanel control = new JPanel();
        Reservation = new JButton("Reservation");
        CancelReservation = new JButton("Cancel Reservation");
        control.add(Reservation);
        control.add(CancelReservation);
        frame.add(control);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final MainBookingView button = this;

        Reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new ReservationCommand(button));
            }
        });

        CancelReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CancelReservationCommand(button));
            }
        });

    }

    public void ReserveViewWindow1()
    {
        JPanel firstWindow = new JPanel();
        JFrame frame = new JFrame("Reservation");
        //JPanel fName = new JPanel();
        JLabel fnameLabel = new JLabel("First Name: ",JLabel.CENTER);
        fnameField = new JTextField("",10);
        firstWindow.add(fnameLabel);
        firstWindow.add(fnameField);

        //JPanel lName = new JPanel();
        JLabel lnameLabel = new JLabel("Last Name: ",JLabel.CENTER);
        lnameField = new JTextField("",10);
        firstWindow.add(lnameLabel);
        firstWindow.add(lnameField);

        nextBtn = new JButton("Next");
        firstWindow.add(nextBtn);

        backBtn = new JButton("Back");
        firstWindow.add(backBtn);

        final MainBookingView button = this;

        frame.add(firstWindow);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new NextCommand(button));
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new BackCommand(button));
            }
        });
    }

    public void ReserveViewWindow2()
    {
        JPanel secondWindow = new JPanel();
        JFrame frame = new JFrame("Reservation");
        JLabel dateInLabel = new JLabel("Date in: ",JLabel.CENTER);
        dateInField = new JTextField("",10);
        secondWindow.add(dateInLabel);
        secondWindow.add(dateInField);

        JLabel dateOutLabel = new JLabel("Date out: ",JLabel.CENTER);
        dateOutField = new JTextField("",10);
        secondWindow.add(dateOutLabel);
        secondWindow.add(dateOutField);

        nextBtn = new JButton("Next");
        secondWindow.add(nextBtn);

        backBtn = new JButton("Back");
        secondWindow.add(backBtn);

        final MainBookingView button = this;

        frame.add(secondWindow);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new NextCommand(button));
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new BackCommand(button));
            }
        });
    }

    //maybe to have less duplicated code?
    //private void action(){

   // }
    private void executeCommand(Command command) {
        command.execute();
    }

}

