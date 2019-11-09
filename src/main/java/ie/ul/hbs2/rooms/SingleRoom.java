package ie.ul.hbs2.rooms;


public class SingleRoom extends Room {

    SingleRoom(int roomNumber, boolean available, double price, int hotelId) {
        super(roomNumber, RoomType.SINGLE, available, price, hotelId);
    }
}
