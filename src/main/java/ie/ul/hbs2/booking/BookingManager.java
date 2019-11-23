package ie.ul.hbs2.booking;

import ie.ul.hbs2.GUI.BookingSummaryView;
import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.database.DatabaseHelper;
import ie.ul.hbs2.database.Query;
import ie.ul.hbs2.database.Row;
import ie.ul.hbs2.payments.IPaymentCallback;
import ie.ul.hbs2.rewards.RewardFactory;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BookingManager implements IPaymentCallback {
    private final DatabaseHelper db = DatabaseHelper.getInstance();
    private final static String dateFormat = "dd/MM/yy";
    private long nights;
    private Booking book;

    public void checkBooking(Booking book, Frame frame) {
        this.book = book;
        if (dateValidation(book.getDateIn(), book.getDateOut())) {
            System.out.println("Hurray,dates are valid");
            book.setTotalSpent(calculateTotalSpent(book));
            getGuestMemberLVL(book.getFirstName(),book.getLastName());
            book.setBID(getNewBID());
            //Booking book = new Booking(this.firstName,this.lastName,this.dateIn,this.dateOut,this.roomType,this.roomAmount);
            BookingSummaryView view = new BookingSummaryView("Booking Summary", frame);
            view.summary(book, this);
            frame.show(view);
        }
    }

    public boolean dateValidation(String dateIn, String dateOut) {
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
            return true;
        } catch (ParseException e) {
            System.out.println("Invalid date(s)");
            return false;
        }
    }

    //Calculating the spent - discount
    public double calculateTotalSpent(Booking book) {
        int rmAmount = book.getRoomsType().length;
        int memLVL = book.getMemLvl();
        double totalSpent = 0 ;
        BookingManager temp = new BookingManager();
        double roomCost =  book.getRoomsPrice();
        float discount;
        discount = RewardFactory.getReward(memLVL).get_discount() / 100;
        totalSpent = ((roomCost * nights));

        //subtract discount
        totalSpent *= 1 - discount;

        return totalSpent;
    }


    /////////////UPDATING/INSERTING to DATABASE//////////////////////////////

    //WIP
    public void addBooking(String dateIn, String dateOut) throws ParseException {
        PreparedStatement st;
        String addQuery = "INSERT INTO `bookings`(`Bid`, `dateIn`, `dateOut`, `Gid`, `Rid`) VALUES (?,?,?,?,?)";

        //DatabaseHelper db = DatabaseHelper.getInstance();
        try {
            st = db.conn().prepareStatement(addQuery);
            Timestamp test = convertDates(dateIn);
            st.setInt(1, getNewBID());
            st.setTimestamp(2, convertDates(dateIn));
            st.setTimestamp(3, convertDates(dateOut));
            st.setInt(4, 201);
            st.setInt(5, 4);
            //st.executeUpdate();
            st.executeUpdate();

            //ResultSet resultSet = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //WIP
    public void updateGuest(String firstName, String lastName, double totalSpent, int membershipLvl) throws ParseException {
        PreparedStatement st;
        String addQuery = "UPDATE `guests` SET (`totalSpent` = ?, membershipLevel = ?) WHERE (`Gid` = ?) VALUES (?,?,?)";
        int GID = getSpecificGID(firstName, lastName);

        try {
            st = db.conn().prepareStatement(addQuery);
            st.setDouble(1, totalSpent);
            st.setInt(2, membershipLvl);
            st.setInt(3, GID);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //works - adds new guest to the DB
    public void addGuest(String firstName, String lastName, String memberSince) throws ParseException {
        PreparedStatement st;
        String addQuery = "INSERT INTO `guests`(`Gid`, `firstName`, `lastName`, `memberSince`, `totalSpent`,membershipLevel) VALUES (?,?,?,?,?,?)";
        if (checkGuest(firstName, lastName)) {
            try {
                st = db.conn().prepareStatement(addQuery);
                // System.out.println(st);
                st.setInt(1, getNewGID() + 1);
                st.setString(2, firstName);
                st.setString(3, lastName);
                st.setString(4, memberSince);
                st.setInt(5, 0);
                st.setInt(6, 0);
                st.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("guest exists in the database");
        }

    }

    //WIP
    public void addPayment(double price,int BID)throws ParseException{
        PreparedStatement st;
        String addQuery = "INSERT INTO `payments`(`Pid`, `IsPaid`, `TotalPrice`, `Bid`) VALUES (?,?,?,?)";

            try {
                st = db.conn().prepareStatement(addQuery);
                // System.out.println(st);
                st.setInt(1, getPID(BID));
                st.setInt(2, 0);
                st.setDouble(3, price);
                st.setInt(4,BID);
                st.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    //WIP
    public void updatePayment(int paid,int BID){

    }


    private boolean checkGuest(String firstName, String lastName) {
        Query query = db.executeQuery("SELECT * FROM `guests` WHERE firstName = '" + firstName + "' AND lastName = '" + lastName + "'");
        if (query.size() == 0) {
            return true;
        } else
            return false;
    }

    public int getNewBID() {
        Query query = db.executeQuery("SELECT * FROM bookings ORDER BY BID DESC LIMIT 1");
        int BID = 0;
        for (int i = 0; i < query.size(); i++) {
            BID = Integer.parseInt(query.get(i).get("BID"));
        }
        return BID +1;
    }

    public int getNewGID() {
        Query query = db.executeQuery("SELECT * FROM guests ORDER BY GID DESC LIMIT 1");
        int GID = 0;
        for (int i = 0; i < query.size(); i++) {
            GID = Integer.parseInt(query.get(i).get("Gid"));
        }

        return GID;
    }

    public void getGuestMemberLVL(String firstName, String lastName) {
        Query query = db.executeQuery("SELECT membershipLevel FROM `guests` WHERE firstName = '"+ firstName +"' AND lastName = '"+ lastName + "'");
        int level = 0;
        for (Row row : query) {
            level = Integer.parseInt(row.get("membershipLevel"));
            System.out.println(level);
        }

        book.setMemLvl(level);
    }

    public int getSpecificGID(String firstName, String lastName) {
        Query query = db.executeQuery("SELECT Gid FROM `guests` WHERE firstName = '" + firstName + "' AND lastName = '" + lastName + "'");
        int GID = 0;
        for (int i = 0; i < query.size(); i++) {
            GID = Integer.parseInt(query.get(i).get("Gid"));
        }

        return GID;
    }

    public int getPID(int Bid)
    {
        Query query = db.executeQuery("SELECT Pid FROM `payments` WHERE Bid = '" + Bid + "'");
        int Pid = 0;
        for (int i = 0; i < query.size(); i++) {
            Pid = Integer.parseInt(query.get(i).get("Pid"));
        }

        return Pid;
    }

    private Timestamp convertDates(String date) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        Date parsedDate = df.parse(date);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        return timestamp;
    }
    //next two methods not needed when finished.
    public int getRoomCost(String rmType) {
        Query query = db.executeQuery("SELECT Price FROM `rooms` WHERE type = '"+ rmType +"' and Hid = 1");
        int cost = 0;
        for (Row row : query) {
            cost = Integer.parseInt(row.get("Price"));
        }
        return cost;
    }

    @Override
    public void doWork() {

    }

    @Override
    public void workDone(boolean successful) {
        System.out.println("Payment was " + successful);
    }
}