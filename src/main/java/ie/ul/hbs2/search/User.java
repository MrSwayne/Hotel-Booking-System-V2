package ie.ul.hbs2.search;

public class User
{
    private int Gid;
    private String firstname;
    private String lastname;
    private int memberSince;
    private int totalSpent;
    private int membershipLevel;

    public int getGid()
    {
        return Gid;
    }
    public String getfirstname()
    {
        return firstname;
    }
    public String getlastname()
    {
        return lastname;
    }
    public int getmemberSince()
    {
        return memberSince;
    }
    public int gettotalSpent()
    {
        return totalSpent;
    }
    public int getmembershipLevel()
    {
        return membershipLevel;
    }

    public User(int Gid,String firstname,String lastname,int memberSince,int totalSpent,int membershipLevel)
    {
        this.Gid = Gid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.memberSince = memberSince;
        this.totalSpent = totalSpent;
        this.membershipLevel = membershipLevel;
    }
}