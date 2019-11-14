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
    private String firstName,lastName,dateIn,dateOut,roomType,roomAmount;
    private int memLvl,BID;
    private double price;
    private long nights;

    private double totalSpent;

    public Booking() {
    }
    public Booking(String firstName, String lastName, String dateIn, String dateOut, String roomType,String roomAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.roomType = roomType;
        this.roomAmount = roomAmount;
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
    public String getRoomType(){
        return roomType;
    }
    public String getRoomAmount(){
        return this.roomAmount;
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

    public void setRoomsTotalPrice(double price){
        this.price = price;
    }
    public double getRoomsPrice(){
        return this.price;
    }


}

