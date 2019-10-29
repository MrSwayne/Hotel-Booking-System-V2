package ie.ul.hbs2.rooms;

public class DoubleRoom extends RoomType {

    @Override
    public String name() {
        return "Double";
    }

    @Override
    public double price() {
        return 100.00;
    }
}
