package ie.ul.hbs2.booking;

import ie.ul.hbs2.database.DatabaseHelper;
import ie.ul.hbs2.database.Query;
import ie.ul.hbs2.database.Row;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingManager {
    private final DatabaseHelper db = DatabaseHelper.getInstance();
    private final static String dateFormat = "dd/MM/yy";
    private Booking book = new Booking();

    public void addBooking(String dateIn, String dateOut) throws ParseException {
        PreparedStatement st;
        String addQuery = "INSERT INTO `bookings`(`Bid`, `dateIn`, `dateOut`, `Gid`, `Rid`) VALUES (?,?,?,?,?)";

        //DatabaseHelper db = DatabaseHelper.getInstance();
        try {
            st = getConnection().prepareStatement(addQuery);
            Timestamp test = convertDates(dateIn);
            st.setInt(1, book.getBID());
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

    public void updateGuest(String firstName, String lastName, double totalSpent, int membershipLvl) throws ParseException {
        PreparedStatement st;
        String addQuery = "UPDATE `guests` SET (`totalSpent` = ?, membershipLevel = ?) WHERE (`Gid` = ?) VALUES (?,?,?)";
        int GID = getSpecificGID(firstName, lastName);

        try {
            st = getConnection().prepareStatement(addQuery);
            st.setDouble(1, totalSpent);
            st.setInt(2, membershipLvl);
            st.setInt(3, GID);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addGuest(String firstName, String lastName, String memberSince) throws ParseException {
        PreparedStatement st;
        String addQuery = "INSERT INTO `guests`(`Gid`, `firstName`, `lastName`, `memberSince`, `totalSpent`,membershipLevel) VALUES (?,?,?,?,?,?)";
        if (checkGuest(firstName, lastName)) {
            try {
                st = getConnection().prepareStatement(addQuery);
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
    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/hbs", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}