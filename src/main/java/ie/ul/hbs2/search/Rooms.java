package ie.ul.hbs2.search;

public class Rooms
{
    private int Rid;
    private int Rnumber;
    private String Type;
    private boolean available;
    private int Price;
    private int Hid;

    public int getRid()
    {
        return Rid;
    }
    public int getRnumber()
    {
        return Rnumber;
    }
    public String getType()
    {
        return Type;
    }
    public Boolean getAvailable()
    {
        return available;
    }
    public int getPrice()
    {
        return Price;
    }
    public int getHid()
    {
        return Hid;
    }

    public Rooms(int Rid,int Rnumber,String Type,boolean available,int Price,int Hid)
    {
        this.Rid = Rid;
        this.Rnumber = Rnumber;
        this.Type = Type;
        this.available = available;
        this.Price = Price;
        this.Hid = Hid;
    }
}
