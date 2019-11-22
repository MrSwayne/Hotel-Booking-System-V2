package ie.ul.hbs2.booking;

import ie.ul.hbs2.GUI.BookingSummaryView;
import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.payments.IPaymentCallback;
import ie.ul.hbs2.rewards.RewardFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking  {
    private final static String dateFormat = "dd/MM/yy";
    private String firstName,lastName,dateIn,dateOut;
    private int memLvl,BID;
    private Object [] rmType;
    private Object [] rmCost;

    private double totalSpent;


    public Booking(String firstName, String lastName, String dateIn, String dateOut,Object[] rmCost,Object [] rmtype) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.rmCost = rmCost;
        this.rmType = rmtype;

    }

    public void setTotalSpent(double spent){
        this.totalSpent = spent;
    }

    public double getTotalSpent(){
        return this.totalSpent;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getDateIn(){
        return dateIn;
    }
    public String getDateOut(){
        return dateOut;
    }

    public void setMemLvl(int memLvl){
        this.memLvl = memLvl;
    }
    public int getMemLvl(){
        return this.memLvl;
    }

    public int getBID(){
        return this.BID;
    }
    public void setBID(int BID){
        this.BID = BID;
    }

    public Object[] getRoomsType(){
        return this.rmType;
    }
    public double getRoomsPrice(){
        double cost = 0;
        for (int i = 0; i<rmCost.length;i++)
        {
            cost = cost  + Double.parseDouble(rmCost[i].toString());
        }
        return cost;
    }


}

