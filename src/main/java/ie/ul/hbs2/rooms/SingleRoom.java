package ie.ul.hbs2.rooms;

public class SingleRoom extends RoomType {

    @Override
    public String name() {
        return "Single";
    }

    @Override
    public double price() {
        return 50.00;
    }
}
