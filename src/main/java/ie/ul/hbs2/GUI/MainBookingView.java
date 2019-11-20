package ie.ul.hbs2.GUI;

import ie.ul.hbs2.booking.*;
import ie.ul.hbs2.common.BackCommand;
import ie.ul.hbs2.common.Command;
import ie.ul.hbs2.common.DoNothingCommand;
import ie.ul.hbs2.common.NextCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MainBookingView extends View implements ActionListener{
    private static JTextArea roomsTypeList;
    private Object [] tempRooms;
    private Object [] costRooms;


    //Booking View and Cancel View buttons and text fields
    private JPanel mainPanel = new JPanel(new GridLayout(2,1));
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField dateInField;
    private JTextField dateOutField;
    private JLabel roomsBooked;
    private JLabel type;
    private CommandJButton nextBtn;
    private CommandJButton backBtn;
    BookingManager manager = new BookingManager();

    public MainBookingView(String name, Frame parent) {
        super(name, parent);
        nextBtn = new CommandJButton(new DoNothingCommand());
        backBtn = new CommandJButton(new DoNothingCommand());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        //mainPanel = new JPanel();

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
        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Rooms Selected: ",JLabel.CENTER);
        type = new JLabel("",10);
        typePanel.add(typeLabel);
        //typePanel.add(type);



        //nextButton
        JPanel control = new JPanel();
        nextBtn.setText("Next");
        buttonPanel.add(nextBtn);

        //backButton
        backBtn.setText("Back");
        buttonPanel.add(backBtn);

        //Adding to main panel
        mainPanel.add(fName);
        mainPanel.add(lName);
        mainPanel.add(dateInPanel);
        mainPanel.add(dateOutPanel);
        mainPanel.add(typePanel);
        //mainPanel.add(control);


        this.add(mainPanel,0);
        this.add(buttonPanel,1);
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
                    dateInField.getText(),dateOutField.getText(),costRooms,tempRooms);//last one need to be modified when search is done
            nextBtn.setCommand(new NextCommand(book,parent));
            nextBtn.execute();
        }  else if(button == backBtn) {
            //backBtn.setCommand(new B;
            backBtn.execute();
        }
    }

        //iterating to get the values.
        public void getRoomsBooked(ArrayList<Object[]> object)//continue when I can switch view from search
        {

            String rmType = "";
            String cost = "";
            tempRooms = new Object[object.size()];
            costRooms = new Object[object.size()];
            for(int i=0;i<object.size();i++)
            {
                Object[] temp = object.get(i);
                System.out.println(temp);


                for(int j =0;j<temp.length;j++){
                    rmType = temp[2].toString();
                    cost = temp[4].toString();

                  //  System.out.println(temp[j]);
                }
                tempRooms[i] = rmType;
                costRooms[i] = cost;

                roomsTypeList = new JTextArea();
                roomsTypeList.setText(tempRooms[i].toString());
                roomsTypeList.setEditable(false);
                mainPanel.add(roomsTypeList);
            }
    }

}


