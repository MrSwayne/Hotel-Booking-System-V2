package ie.ul.hbs2.GUI;

import ie.ul.hbs2.booking.*;
import ie.ul.hbs2.common.BackCommand;
import ie.ul.hbs2.common.DoNothingCommand;
import ie.ul.hbs2.common.NextCommand;
import ie.ul.hbs2.memento.CareTaker;
import ie.ul.hbs2.memento.Memento;
import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainBookingView extends View implements ActionListener{
    private static JTextArea roomsTypeList;
    private Object [] tempRooms;
    private Object [] costRooms;
    private Object [] roomdIDs;
    private JPanel mementoPanel = new JPanel(new GridLayout(2,1));

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    private JDatePickerImpl checkInDatePicker;
    private JDatePickerImpl checkOutDatePicker;

    //Booking View and Cancel View buttons and text fields
    private JPanel mainPanel = new JPanel(new GridLayout(2,1));
    private JTextField fnameField;
    private JTextField lnameField;
    private String dateIn;
    private String dateOut;
    private Date selectedDateIn;
    private Date selectedDateOut;
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

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        checkInDatePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());

        UtilDateModel model2 = new UtilDateModel();
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
        checkOutDatePicker = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

        // Label and Field
        JPanel dateInPanel = new JPanel();
        JLabel dateInLabel = new JLabel("Date in: ",JLabel.CENTER);
        dateInPanel.add(dateInLabel);
        dateInPanel.add(checkInDatePicker);


        // Label and Field
        JPanel dateOutPanel = new JPanel();
        JLabel dateOutLabel = new JLabel("Date out: ",JLabel.CENTER);
        dateOutPanel.add(dateOutLabel);
        dateOutPanel.add(checkOutDatePicker);


        // Label and Field -- delete after search is done
        JPanel typePanel = new JPanel();
        JLabel typeLabel = new JLabel("Rooms Selected: ",JLabel.CENTER);
        type = new JLabel("",10);
        typePanel.add(typeLabel);


        //nextButton
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

        mementoPanel.add(mainPanel);
        mementoPanel.add(buttonPanel);

        this.add(mementoPanel);
        this.setVisible(true);


        //all the buttons you want to add.
        nextBtn.addActionListener(this );
        backBtn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();


        if (button == nextBtn) {
            selectedDateIn = (Date) checkInDatePicker.getModel().getValue();
            selectedDateOut =  (Date) checkOutDatePicker.getModel().getValue();
            if(selectedDateIn == null || selectedDateOut == null)
            {
                dateIn = "";
                dateOut = "";
            }else{
                dateIn = dateFormat.format(selectedDateIn);
                dateOut = dateFormat.format(selectedDateOut);
            }
            if(fnameField.getText().isEmpty() || lnameField.getText().isEmpty())
            {
                System.out.println("Please enter name and last name");
            }
            else {

                Booking book = new Booking(fnameField.getText(), lnameField.getText(),
                        dateIn, dateOut, costRooms, tempRooms, roomdIDs);
                CareTaker.getInstance().add(new Memento(mementoPanel));
                nextBtn.setCommand(new NextCommand(book, parent));
                nextBtn.execute();
            }

        }  else if(button == backBtn) {
            backBtn.setCommand(new BackCommand(CareTaker.getInstance().get(1), parent));
            backBtn.execute();
        }
    }

        //iterating to get the values.
        public void getRoomsBooked(ArrayList<Object[]> object)//continue when I can switch view from search
        {

            String rmType = "";
            String cost = "";
            int RID = 0;
            tempRooms = new Object[object.size()];
            costRooms = new Object[object.size()];
            roomdIDs = new Object[object.size()];
            for(int i=0;i<object.size();i++)
            {
                Object[] temp = object.get(i);
                System.out.println(temp);


                for(int j =0;j<temp.length;j++){
                    rmType = temp[2].toString();
                    cost = temp[4].toString();
                    RID = Integer.parseInt(temp[0].toString());


                  //  System.out.println(temp[j]);
                }
                tempRooms[i] = rmType;
                costRooms[i] = cost;
                roomdIDs[i] = RID;
                System.out.println(RID);

                roomsTypeList = new JTextArea();
                roomsTypeList.setText(tempRooms[i].toString());
                roomsTypeList.setEditable(false);
                mainPanel.add(roomsTypeList);
            }
    }

}

class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern = "dd/MM/yy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

}


