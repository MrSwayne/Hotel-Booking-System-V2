package src.ie.ul.hbs2.booking;

import src.ie.ul.hbs2.booking.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button {
    public JTextArea textField;
    public String clipboard;
    
    public void init() {
    JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
    JPanel content = new JPanel();
    frame.setContentPane(content);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    textField = new JTextArea();
    textField.setLineWrap(true);
    content.add(textField);
    JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton booking = new JButton("Booking");
    JButton cancelBooking = new JButton("Cancel Booking");
    Button button = this;
    
    
    //all the buttons you want to add.
    booking.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	    executeCommand(new BookingCommand(button));
	}
    });
    
    buttons.add(booking);
    content.add(buttons);
    frame.setSize(450, 200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
   
    }
    private void executeCommand(Command command) {
        command.execute();
    } 
}