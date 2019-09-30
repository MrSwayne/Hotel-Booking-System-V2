package ie.ul.hbs2.booking;

import ie.ul.hbs2.booking.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingView {
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
    private JTextField cancelField;
    //private JPasswordField passwordField;
    
    public void init() {
	
	JPanel mainPanel = new JPanel();
	JFrame frame = new JFrame("Booking");
	
	mainPanel = new JPanel(new GridLayout(3,1));
	
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
	
	//SubmitButton
	JPanel control = new JPanel();
	submitBtn = new JButton("Submit");
	control.add(submitBtn);
	
	//CancelButton
	cancelBtn = new JButton("Cancel");
	control.add(cancelBtn);
	
	//Adding to main panel
	mainPanel.add(fName);
	mainPanel.add(lName);
	mainPanel.add(dateInPanel);
	mainPanel.add(dateOutPanel);
	mainPanel.add(typePanel);
	mainPanel.add(roomsPanel);
	mainPanel.add(cancelID);
	mainPanel.add(control);
	
	//display the panel
	frame.add(mainPanel);
	frame.setVisible(true);
	frame.pack();
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	BookingView button = this;
    
    
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
    private void executeCommand(Command command) {
        command.execute();
    } 
}