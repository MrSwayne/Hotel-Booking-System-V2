package ie.ul.hbs2;

import ie.ul.hbs2.database.DatabaseHelper;
import ie.ul.hbs2.search.Hotel1Strategy;
import ie.ul.hbs2.search.SearchStrategy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManipulationExamples
{
    private Object DatabaseHelper;
    //Prepared statements are used for executing queries or updating an SQL DB
    //an example of a simple prepared statement for adding a booking:

    //get your SQL connection, not sure if DB helper allows to update/write to DB
    public boolean addBooking(int Bid, String dateIn, String dateOut, int Gid, int Rid) throws SQLException {
        PreparedStatement st;
        String addQuery= "INSERT INTO `bookings`(`Bid`, `dateIn`, `dateOut`, `Gid`, `Rid`) VALUES (?,?,?,?,?)";
        //For an update of a booking, using UPDATE instead of INSERT INTO

        //Unsure if DB helper can be used to hold a connection/send back up to DB, should be clarified with Adam
        //Otherwise, another connection needs to be opened
        //DatabaseHelper db = DatabaseHelper.getInstance();

        //The below will open the connection, awaiting a query to be executed.
        st= getConnection().prepareStatement(addQuery);

        st.setInt(1,Bid);
        st.setString(2,dateIn);
        st.setString(3,dateOut);
        st.setInt(4,Gid);
        st.setInt(5,Rid);

        //Whatever you pass in for the Bid, dateIn etc... will fill the above slots, I assume this data will be taken from the action event of typing
        //into the booking boxes.
        //

        st.executeUpdate(); //For updates
        st.executeQuery(); //For inserts
        //You may have to use ResultSet resultSet = st.executeQuery();... Not sure.

        //For the example just using a boolean returning true, it might be wise here to use a try catch, checking if the room is reserved. Or a boolean may not be used whatsoever, just an example.
        return true;
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
