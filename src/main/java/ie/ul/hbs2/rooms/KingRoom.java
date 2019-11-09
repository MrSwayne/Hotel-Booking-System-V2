package ie.ul.hbs2.rooms;

public class KingRoom extends Room {

    KingRoom(int roomNumber, boolean available, double price, int hotelId) {
        super(roomNumber, RoomType.KING, available, price, hotelId);
    }
}
