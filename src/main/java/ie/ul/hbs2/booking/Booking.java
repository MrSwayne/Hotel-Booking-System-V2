package ie.ul.hbs2.booking;

import ie.ul.hbs2.GUI.BookingSummaryView;
import ie.ul.hbs2.database.*;
import ie.ul.hbs2.rewards.RewardFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    final static String dateFormat = "dd/MM/yy";
    int nights;

    //I need information of how the rooms are getting done and Discounts, can go forward if I have them.
    public boolean checkBooking(String firstName, String lastName, String dateIn, String dateOut, String roomAmount,
                                String roomType) {

        //check if the name correspond to any in the db otherwise set everything as a new customer.
        if (dateValidation(dateIn, dateOut)) {
            System.out.println("Hurray,dates are valid");
            if (roomsAvailable(roomAmount, roomType)) {
                bookingApp(firstName, lastName, dateIn, dateOut, roomAmount, roomType);
                return true;
            }
        }
        return false;
    }

    public boolean dateValidation(String dateIn, String dateOut) {

        if (dateIn == null || dateOut == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateIn);
            Date date2 = sdf.parse(dateOut);
            // bookingM.setDateIn(dateIn);
            // bookingM.setDateOut(dateOut);
            long diff = date2.getTime() - date.getTime();
            nights = (int) (diff / (1000 * 60 * 60 * 24));
            //bookingM.setAmountOfNights(nights);
            System.out.println(date + " " + date2);
        } catch (ParseException e) {
            System.out.println("Invalid date(s)");
            return false;
        }
        return true;
    }

    public boolean roomsAvailable(String roomAmount, String roomType) {
        if (roomAmount != null || roomType != null) {
            if (roomAmount.matches("[0-9]+")) {
                int rmNumber = Integer.parseInt(roomAmount);
                if ((rmNumber <= 50 || roomType.equals("Single"))) {
                    //Need to check from database
                    if (true) {
                        System.out.println("Hurray,room is available");
                        return true;
                    }
                } else if (rmNumber <= 100 || roomType.equals("Double")) {
                    //Need to check from database
                    if (true) {
                        System.out.println("Hurray,room is available");
                        return true;
                    } else if ((rmNumber <= 150 || roomType.equals("King"))) {
                        //Need to check from database
                        if (true) {
                            System.out.println("Hurray,room is available");
                            return true;
                        } else {
                            System.out.println("No rooms available.");
                        }
                    }
                }

            }
        }
        return false;
    }

    //Calculating the spent - discount will do this later
   public double calculateTotalSpent(String firstName, String lastName, String dateIn, String dateOut, String roomAmount,String roomType) {

        int rmBooked = Integer.parseInt(roomAmount);
        int memLVL = getCustomerInformation(firstName,lastName);
        double totalSpent = 0 ;
        int roomCost =  getRoomCost(roomType);
        RewardFactory factory = new RewardFactory() {};
        float discount;
       if(memLVL == 1) // Bronze reward
        {
            discount = factory.getReward("Bronze").get_discount() / 100;
            totalSpent = ((roomCost * nights) * rmBooked) * discount;
        }else if(memLVL == 2) // silver
        {
            discount = factory.getReward("Silver").get_discount() / 100;
            totalSpent = ((roomCost * nights) * rmBooked) * discount;

        }
        else if(memLVL == 3) // gold
        {
            discount = factory.getReward("Gold").get_discount() / 100;
            totalSpent = ((roomCost * nights) * rmBooked) * discount;
        }
        else if(memLVL==4) // platinum
       {
           discount = factory.getReward("Platinum").get_discount() / 100;
           totalSpent = ((roomCost * nights) * rmBooked) * discount;
       }
        else if (memLVL == 5) // VIP
       {
           discount = factory.getReward("VIP").get_discount() / 100;
           totalSpent = ((roomCost * nights) * rmBooked) * discount;
       }else {
            totalSpent = ((roomCost * nights) * rmBooked);
        }
        return totalSpent;
    }

    private int getRoomCost(String rmType) {
        DatabaseHelper db = DatabaseHelper.getInstance();
        Query query = db.executeQuery("SELECT Price FROM `rooms` WHERE type = '"+ rmType +"' and Hid = 1");
        int cost = 0;
        for (int i = 0 ; i < query.size();i++){
            cost = Integer.parseInt(query.get(i).get("Price"));
        }
        return cost;
    }

    private int getCustomerInformation(String firstName, String lastName) {
        DatabaseHelper db = DatabaseHelper.getInstance();
        Query query = db.executeQuery("SELECT membershipLevel FROM `guests` WHERE firstName = '"+ firstName +"' AND lastName = '"+ lastName + "'");
        int level = 0;
        for (int i =0 ; i < query.size();i++)
        {
            level = Integer.parseInt(query.get(i).get("membershipLevel"));
        }

        return level;
    }

    public void bookingApp(String firstName, String lastName, String dateIn, String dateOut, String roomAmount, String roomType) {
        double totalSpent = calculateTotalSpent(firstName, lastName, dateIn, dateOut, roomAmount, roomType);
        int BID = getBID();
        System.out.println(BID);
        BookingSummaryView view = new BookingSummaryView();
        view.summary(firstName, lastName, dateIn, dateOut, roomAmount, roomType, BID, totalSpent);

        System.out.println("You have booked a reservation with BID" + BID + " total cost = " + totalSpent);
    }

    public int getBID(){
        DatabaseHelper db = DatabaseHelper.getInstance();
        Query query = db.executeQuery("SELECT * FROM bookings ORDER BY BID DESC LIMIT 1");
        int BID =0;
        for (int i =0 ; i < query.size();i++)
        {
            BID = Integer.parseInt(query.get(i).get("BID"));
        }

        return BID + 1;

    }
}
