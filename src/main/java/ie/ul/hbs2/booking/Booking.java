package ie.ul.hbs2.booking;

import ie.ul.hbs2.GUI.BookingSummaryView;
import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.database.*;
import ie.ul.hbs2.payments.IPaymentCallback;
import ie.ul.hbs2.rewards.RewardFactory;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking implements IPaymentCallback {
    private final static String dateFormat = "dd-mm-yyyy";
    private String firstName,lastName,dateIn,dateOut,roomType,roomAmount;
    private int nights;

    public Booking() {
    }
    public Booking(String firstName, String lastName, String dateIn, String dateOut, String roomType, String roomAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.roomType = roomType;
        this.roomAmount = roomAmount;

    }

    //I need information of how the rooms are getting done and Discounts, can go forward if I have them.
    public boolean checkBooking(Frame frame, Booking book) {
        System.out.println(dateIn);
        //check if the name correspond to any in the db otherwise set everything as a new customer.
        if (dateValidation(dateIn, dateOut)) {
            System.out.println("Hurray,dates are valid");
            if (roomsAvailable(roomAmount,roomType)) {
                bookingApp(frame, book);
                return true;
            }
        }
        return false;
    }

    private boolean dateValidation(String dateIn, String dateOut) {

        if (dateIn == null || dateOut == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateIn);
            Date date2 = sdf.parse(dateOut);
            long diff = date2.getTime() - date.getTime();
            nights = (int) (diff / (1000 * 60 * 60 * 24));
            System.out.println(date + " " + date2);
        } catch (ParseException e) {
            System.out.println("Invalid date(s)");
            return false;
        }
        return true;
    }

    // not needed after search is done.
    private boolean roomsAvailable(String roomAmount, String roomType) {
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

    private void bookingApp(Frame frame, Booking book) {
        //totalSpent = calculateTotalSpent();
        int BID = getBID();
        //System.out.println(BID);
        BookingSummaryView view = new BookingSummaryView("Booking Summary", frame);
        view.summary(book, this);
        frame.show(view);

        //System.out.println("You have booked a reservation with BID" + BID + " total cost = " + totalSpent);
    }

    //Calculating the spent - discount
   public double calculateTotalSpent() {
        int rmBooked = Integer.parseInt(roomAmount);
        int memLVL = getCustomerInformation(firstName,lastName);
        double totalSpent = 0 ;
        int roomCost =  getRoomCost(roomType);
        float discount;

       discount = RewardFactory.getReward(memLVL).get_discount() / 100;
       totalSpent = ((roomCost * nights) * rmBooked);
       System.out.println(totalSpent);
       System.out.println(memLVL);

       //subtract discount
       totalSpent *= 1 - discount;

        return totalSpent;
    }

    private int getRoomCost(String rmType) {
        DatabaseHelper db = DatabaseHelper.getInstance();
        Query query = db.executeQuery("SELECT Price FROM `rooms` WHERE type = '"+ rmType +"' and Hid = 1");
        int cost = 0;
        for (Row row : query) {
            cost = Integer.parseInt(row.get("Price"));
        }
        return cost;
    }

    private int getCustomerInformation(String firstName, String lastName) {
        DatabaseHelper db = DatabaseHelper.getInstance();
        Query query = db.executeQuery("SELECT membershipLevel FROM `guests` WHERE firstName = '"+ firstName +"' AND lastName = '"+ lastName + "'");
        int level = 0;
        for (Row row : query) {
            level = Integer.parseInt(row.get("membershipLevel"));
        }

        return level;
    }

    public void addBooking(String dateIn, String dateOut) throws ParseException {
        System.out.println(convertDates(dateIn));
        System.out.println(convertDates(dateOut));
        PreparedStatement st;
        String addQuery = "INSERT INTO `bookings`(`Bid`, `dateIn`, `dateOut`, `Gid`, `Rid`) VALUES (?,?,?,?,?)";

        //DatabaseHelper db = DatabaseHelper.getInstance();
        try {
            st = getConnection().prepareStatement(addQuery);
           // System.out.println(st);
            st.setInt(1,getBID());
            st.setTimestamp(2, convertDates(dateIn));
            st.setTimestamp(3, convertDates(dateOut));
            st.setInt(4, 201);
            st.setInt(5, 110);
            System.out.println(st);
            //st.executeUpdate();
            st.executeQuery();

            //ResultSet resultSet = st.executeQuery();
            //System.out.println(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        return roomAmount;
    }

    @Override
    public void doWork() {

    }

    @Override
    public void workDone(boolean successful) {

    }


    private Timestamp convertDates(String date) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        Date parsedDate = df.parse(date);
        System.out.println(parsedDate);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        System.out.println(timestamp);
        return timestamp;
    }

    public Connection getConnection()
    {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/hbs", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }

}

