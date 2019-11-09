package ie.ul.hbs2.rooms;

public class RoomFactory extends AbstractFactory {
    @Override
    Room getRoom(String roomType, int roomNumber, boolean available, int hotelId) {
        if (roomType == null) {
            return null;
        }

        if (roomType.equalsIgnoreCase("SINGLE")) {
            return new SingleRoom(roomNumber, available, 50, hotelId);
        } else if (roomType.equalsIgnoreCase("DOUBLE")) {
            return new DoubleRoom(roomNumber, available, 100, hotelId);
        } else if (roomType.equalsIgnoreCase("KING")) {
            return new KingRoom(roomNumber, available, 150, hotelId);
        }

        return null;
    }
}
