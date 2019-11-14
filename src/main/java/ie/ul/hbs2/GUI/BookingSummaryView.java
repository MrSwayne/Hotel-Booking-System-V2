package ie.ul.hbs2.GUI;

import ie.ul.hbs2.booking.*;
import ie.ul.hbs2.booking.memento.CareTaker;
import ie.ul.hbs2.booking.memento.Memento;
import ie.ul.hbs2.payments.IPaymentCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class BookingSummaryView extends View implements ActionListener {

    private IPaymentCallback callback;
    private JButton submitBtn = null;
    private JButton cancelBtn = null;
    private double totalSpent;
    private Booking book;
    public BookingSummaryView(String name, Frame parent) {
        super(name, parent);
    }

    public void summary(Booking book, IPaymentCallback callback)
    {
       this.book = book;
        this.callback = callback;
        //this.totalSpent = manager.calculateTotalSpent();
        System.out.println("normal" + totalSpent);
        System.out.println("get method" + book.getTotalSpent());
        JPanel mainPanel = new JPanel();

        mainPanel = new JPanel(new GridLayout(3,1));

        JLabel bookingID = new JLabel("Booking ID: ",JLabel.CENTER);
        JLabel bidLabel = new JLabel(String.valueOf(book.getBID()),JLabel.CENTER);

        JLabel fNameLabel = new JLabel("First Name: ",JLabel.CENTER);
        JLabel nameLabel = new JLabel(book.getFirstName(),JLabel.CENTER);

        JLabel lNameLabel = new JLabel("Last Name: ",JLabel.CENTER);
        JLabel lastLabel = new JLabel(book.getLastName(),JLabel.CENTER);

        JLabel checkInDate = new JLabel("Check In Date: ",JLabel.CENTER);
        JLabel dateInLabel = new JLabel(book.getDateIn(),JLabel.CENTER);

        JLabel checkOutDate = new JLabel("Check Out Date ",JLabel.CENTER);
        JLabel dateOutLabel = new JLabel(book.getDateOut(),JLabel.CENTER);

        JLabel roomTotal = new JLabel("Room Total: ",JLabel.CENTER);
        JLabel roomAmountLabel = new JLabel(String.valueOf(book.getRoomAmount()),JLabel.CENTER);

        JLabel roomClass = new JLabel("Room Type: ",JLabel.CENTER);
        JLabel roomTypeLabel = new JLabel(book.getRoomType(),JLabel.CENTER);

        final JLabel totalAmount = new JLabel("Total Amount: ",JLabel.CENTER);
        JLabel totalLabel = new JLabel(String.valueOf(book.getTotalSpent()),JLabel.CENTER);


        //SubmitButton
        JPanel control = new JPanel();
        submitBtn = new JButton("Submit");
        control.add(submitBtn);

        //CancelButton
        cancelBtn = new JButton("Cancel");
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
        mainPanel.add(roomClass);
        mainPanel.add(roomTypeLabel);
        mainPanel.add(totalAmount);
        mainPanel.add(totalLabel);

        mainPanel.add(control);
        this.add(mainPanel);

        //all the buttons you want to add.
        submitBtn.addActionListener(this);

        cancelBtn.addActionListener(this);

    }
    private void executeCommand(CommandSummary command) {
        command.execute();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if(button == submitBtn) {
            System.out.println("Processing payment now");
            //Code to call Adam's method in payment view
            try {
                BookingManager manager = new BookingManager();
               //book.addBooking(book.getDateIn(),book.getDateOut());
               manager.addGuest(book.getFirstName(),book.getLastName(),book.getDateIn());
               //manager.updateGuest(book.getFirstName(),book.getLastName(),book.getTotalSpent(),book.getMemLvl());
                manager.addPayment(book.getTotalSpent(),book.getBID());


            } catch (ParseException ex) {
                ex.printStackTrace();
             }

            PaymentView paymentView = (PaymentView) parent.get("payments");
           paymentView.showPaymentScreen(this.callback, book); // pass book here now?

            executeCommand(new SubmitCommand(this));
        } else if(button == cancelBtn) {
            //Still need to work at the memento


            executeCommand(new CancelCommand(this));
        }
    }
}