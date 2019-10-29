package ie.ul.hbs2.rooms;

public class KingRoom extends RoomType {

    @Override
    public String name() {
        return "King";
    }

    @Override
    public double price() {
        return 150.00;
    }
}
