package ie.ul.hbs2.rooms;

public abstract class AbstractFactory {
    abstract Room getRoom(String roomType, int roomNumber, boolean available, int hotelId);
}
