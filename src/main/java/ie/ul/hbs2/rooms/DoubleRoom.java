package ie.ul.hbs2.rooms;

public class DoubleRoom extends Room {

    DoubleRoom(int roomNumber, boolean available, double price, int hotelId) {
        super(roomNumber, RoomType.DOUBLE, available, price, hotelId);
    }
}
