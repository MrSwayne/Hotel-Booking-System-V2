package ie.ul.hbs2.booking;

import ie.ul.hbs2.GUI.BookingSummaryView;
import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.payments.IPaymentCallback;
import ie.ul.hbs2.rewards.RewardFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking implements IPaymentCallback {
    private final static String dateFormat = "dd/MM/yy";
    private String firstName,lastName,dateIn,dateOut,roomType,roomAmount;
    private int memLvl,BID;
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

    public void checkBooking(Booking book,Frame frame) {
        if (dateValidation(dateIn, dateOut)) {
            System.out.println("Hurray,dates are valid");
                setTotalSpent(calculateTotalSpent());
                BookingManager temp = new BookingManager();
                //temp.getGuestMemberLVL(firstName,lastName);
                setBID(temp.getNewBID());
               //Booking book = new Booking(this.firstName,this.lastName,this.dateIn,this.dateOut,this.roomType,this.roomAmount);
                BookingSummaryView view = new BookingSummaryView("Booking Summary", frame);
                view.summary(book, this);
                frame.show(view);
        }
    }

    private boolean dateValidation(String dateIn, String dateOut) {
       // System.out.println(dateIn);
       // System.out.println(dateOut);
        if (dateIn == null || dateOut == null) {
            System.out.println("Null Dates");
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateIn);
            Date date2 = sdf.parse(dateOut);
            long diff = Math.abs(date2.getTime() - date.getTime());
            nights =  (diff / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            System.out.println("Invalid date(s)");
            return true;
        }
        return true;
    }

    //Calculating the spent - discount
   public double calculateTotalSpent() {
        int rmBooked = Integer.parseInt(roomAmount);
        int memLVL = getMemLvl();
        double totalSpent = 0 ;
        BookingManager temp = new BookingManager();
        int roomCost =  temp.getRoomCost(roomType);
        float discount;
       discount = RewardFactory.getReward(memLVL).get_discount() / 100;
       totalSpent = ((roomCost * nights) * rmBooked);

       //subtract discount
       totalSpent *= 1 - discount;

        return totalSpent;
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
    @Override
    public void doWork() {

    }

    @Override
    public void workDone(boolean successful) {

    }

}

