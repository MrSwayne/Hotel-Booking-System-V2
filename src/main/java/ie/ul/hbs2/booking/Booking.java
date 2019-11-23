package ie.ul.hbs2.booking;

public class Booking  {
    private final static String dateFormat = "dd/MM/yy";
    private String firstName,lastName,dateIn,dateOut;
    private int memLvl,BID;
    private Object [] rmType;
    private Object [] rmCost;
    private Object [] roomsID;

    private double totalSpent;


    public Booking(String firstName, String lastName, String dateIn, String dateOut,Object[] rmCost,Object [] rmtype,Object [] roomsID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.rmCost = rmCost;
        this.rmType = rmtype;
        this.roomsID = roomsID;
    }

    public Booking() {

    }

    public void setTotalSpent(double spent){
        this.totalSpent = spent;
    }

    public double getTotalSpent(){
        return this.totalSpent;
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

    public void setMemLvl(int memLvl){
        this.memLvl = memLvl;
    }
    public int getMemLvl(){
        return this.memLvl;
    }

    public int getBID(){
        return this.BID;
    }
    public void setBID(int BID){
        this.BID = BID;
    }

    public Object[] getRoomsType(){
        return this.rmType;
    }
    public double getRoomsPrice(){
        double cost = 0;
        for (int i = 0; i<rmCost.length;i++)
        {
            cost = cost  + Double.parseDouble(rmCost[i].toString());
        }
        return cost;
    }

    public int[] getRID(){
        int [] rid = new int[roomsID.length];
        for (int i = 0; i< rid.length;i++)
        {
            rid[i] = Integer.parseInt(roomsID[i].toString());
        }
        return rid;
    }
}

