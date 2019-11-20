package ie.ul.hbs2.logging;

import java.util.Date;

public class ContextObject {
    private String firstName;
    private String lastName;
    private Date loginTime;
    private Date logoutTime;



    public ContextObject(String firstName, String lastName, Date loginTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginTime = loginTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }
}
