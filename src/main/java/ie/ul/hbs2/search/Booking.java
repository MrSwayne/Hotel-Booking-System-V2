package ie.ul.hbs2.search;

public class Booking
{
    private int Bid;
    private int dateIn;
    private int dateout;
    private int Gid;
    private int Rid;

    public int getBid()
    {
        return Bid;
    }
    public int getdateIn()
    {
        return dateIn;
    }
    public int getdateOut()
    {
        return dateout;
    }
    public int getGid()
    {
        return Gid;
    }
    public int getRid()
    {
        return Rid;
    }

    public Booking(int Bid, int dateIn, int dateout, int Gid, int Rid)
    {
        this.Bid = Bid;
        this.dateIn = dateIn;
        this.dateout = dateout;
        this.Gid = Gid;
        this.Rid = Rid;
    }
}