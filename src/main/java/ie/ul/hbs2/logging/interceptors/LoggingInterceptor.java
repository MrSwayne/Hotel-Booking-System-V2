package ie.ul.hbs2.logging.interceptors;

import ie.ul.hbs2.database.DatabaseHelper;
import ie.ul.hbs2.database.Query;
import ie.ul.hbs2.logging.ContextObject;
import ie.ul.hbs2.logging.IInterceptor;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoggingInterceptor implements IInterceptor {

    private PreparedStatement st;
    private DatabaseHelper db;

    public LoggingInterceptor() {
        db = DatabaseHelper.getInstance();
    }

    @Override
    public void preLoginReply(ContextObject context) {
        String addQuery= "INSERT INTO `logins`(`FirstName`, `LastName`, `LoginTime`) VALUES (?,?,?)";
        try {
            st = db.conn().prepareStatement(addQuery);

            st.setString(1, context.getFirstName());
            st.setString(2, context.getLastName());
            st.setString(3, String.valueOf(context.getLoginTime()));

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postLogoutReply(ContextObject context) {
        Query query = db.executeQuery("SELECT * FROM logins ORDER BY Lid DESC LIMIT 1");
        int id = 0;
        for (int i = 0; i < query.size(); i++) {
            if (i == query.size() - 1) {
                id = Integer.parseInt(query.get(i).get("Lid"));
            }
        }
        String addQuery= "UPDATE `logins` SET `logoutTime` = ?, `totalTime` = TIMESTAMPDIFF(second, `loginTime`, `logoutTime`) WHERE `Lid` = ?";
        try {

            st = db.conn().prepareStatement(addQuery);

            System.out.println("Log in time: " + context.getLoginTime());
            st.setString(1, String.valueOf(context.getLogoutTime()));
            System.out.println("Log out time: " + context.getLogoutTime());
            st.setInt(2, id);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
