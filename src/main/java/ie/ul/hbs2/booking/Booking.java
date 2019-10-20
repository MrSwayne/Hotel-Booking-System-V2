package ie.ul.hbs2.booking;

import ie.ul.hbs2.GUI.BookingSummaryView;
import ie.ul.hbs2.payments.BookingCharge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    final static String dateFormat = "dd/MM/yy";

    //I need information of how the rooms are getting done and Discounts, can go forward if I have them.
    public boolean checkBooking(String firstName, String lastName, String dateIn, String dateOut, String roomAmount,
                                String roomType) {
        //hard coded at the moment -> change it later...
        // bookingM.getInformation();

        //guestM.getInformation(); DB
        //roomM.getInformation();
        //guestM.setMemLev(1);

        //guestM.getInformation();
        //roomM.getInfortmation();
        //roomM.setRoomNumber(50);
        // roomM.setType("Double");
        // roomM.setPrice(60);
        // roomM.setAvailability(true);
        //guestM.setMemLev(1);
        //bookingM.setGID(0);
        //check if the name correspond to any in the db otherwise set everything as a new customer.
        if (dateValidation(dateIn, dateOut)) {
            System.out.println("Hurray,dates are valid");
            if (roomsAvailable(roomAmount, roomType)) {
                bookingProgram(firstName, lastName, dateIn, dateOut, roomAmount, roomType);
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
            int nights = (int) (diff / (1000 * 60 * 60 * 24));
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
                }
            }
        }
        return false;
    }

    //Calculating the spent - discount will do this later
   /* public double calculateTotalSpent(String firstName, String lastName, String dateIn, String dateOut, String roomAmount,String roomType) {
        //guestM.setFirstName(firstName);
        //guestM.setLastName(lastName);
       // Discount silver = new Silver();
       // Discount gold = new Gold();
       // Discount plat = new Platinum();
     //   int memLev = guestM.getMemLev();
        int rmBooked = Integer.parseInt(roomAmount);
        double totalSpent;
        double roomCost = roomM.getPrice();
     / int nights = bookingM.getAmountOfNights();
        double discount;
       if(memLev == 1)
        {
            silver.setDiscount(100.00);
            discount = silver.getDiscount();
            totalSpent = ((roomCost * nights) * rmBooked) - discount;
            guestM.setTotalSpent(totalSpent);
            bookingM.setBooking();
        }else if(memLev == 2)
        {
            gold.setDiscount(200.00);
            discount = gold.getDiscount();
            totalSpent = ((roomCost * nights) * rmBooked) - discount;
            guestM.setTotalSpent(totalSpent);
            bookingM.setBooking();
        }
        else if(memLev == 3)
        {
            plat.setDiscount(300.00);
            discount = plat.getDiscount();
            totalSpent = ((roomCost * nights) * rmBooked) - discount;
            guestM.setTotalSpent(totalSpent);
            bookingM.setBooking();
        }else
        {
            totalSpent = ((roomCost * nights) * rmBooked);
            guestM.setTotalSpent(totalSpent);
            //bookingM.setBooking();
        }
        return totalSpent;
    }*/

    public double bookingProgram(String firstName, String lastName, String dateIn, String dateOut, String roomAmount, String roomType) {
        double totalSpent = 1000.00;//calculateTotalSpent(firstName, lastName, dateIn, dateOut, roomAmount, roomType);
        BookingSummaryView view = new BookingSummaryView();
        view.summary(firstName, lastName, dateIn, dateOut, roomAmount, roomType, 100, totalSpent);

        System.out.println("You have booked a reservation with ID" + "Random BID" + " total cost = " + totalSpent);
        return totalSpent;
    }
}
