package ie.ul.hbs2.GUI;

import ie.ul.hbs2.booking.BackCommand;
import ie.ul.hbs2.booking.Booking;
import ie.ul.hbs2.booking.Command;
import ie.ul.hbs2.booking.NextCommand;
import ie.ul.hbs2.booking.memento.CareTaker;
import ie.ul.hbs2.booking.memento.Memento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MainBookingView extends View implements ActionListener{
    public JTextArea textField;
    public String clipboard;
    MainBookingView bookview;

    //Booking View and Cancel View buttons and text fields
    public JPanel mainPanel;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField dateInField;
    private JTextField dateOutField;
    private JTextField roomsBooked;
    private JTextField type;
    private JButton nextBtn;
    private JButton backBtn;

    public MainBookingView(String name, Frame parent) {
        super(name, parent);

        mainPanel = new JPanel();

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

        // Label and Field -- delete after search is done
        JPanel roomsPanel = new JPanel();
        JLabel roomLabel = new JLabel("Rooms: ",JLabel.CENTER);
        roomsBooked= new JTextField("",10);
        roomsPanel.add(roomLabel);
        roomsPanel.add(roomsBooked);

        // Label and Field -- delete after search is done
        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Type: ",JLabel.CENTER);
        type = new JTextField("",10);
        typePanel.add(typeLabel);
        typePanel.add(type);



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
        mainPanel.add(control);

        this.add(mainPanel);
        this.setVisible(true);
       // parent.show(this);

        //all the buttons you want to add.
        nextBtn.addActionListener(this );
        backBtn.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();

        if (button == nextBtn) {
            Booking  book = new Booking(fnameField.getText(),lnameField.getText(),
                    dateInField.getText(),dateOutField.getText(),type.getText(),roomsBooked.getText());//last one need to be modified when search is done
            book.checkBooking(book,this.parent);
            executeCommand(new NextCommand(this));
        }  else if(button == backBtn) {
            executeCommand(new BackCommand(this));
        }
    }

    private void executeCommand(Command command) {
        CareTaker c = new CareTaker();
        Memento m = new Memento(mainPanel);
        c.add(m);
        command.execute();
    }

        //WIP
        public void getRoomsBooked(ArrayList<Object[]> object)
        {
            System.out.println("getrooms");

            for(int i=0;i<object.size();i++)
            {
                Object[] temp = object.get(i);

                for(int j =0;j<temp.length;j++){
                    System.out.println(temp[j]);
                }
            }
    }

}


