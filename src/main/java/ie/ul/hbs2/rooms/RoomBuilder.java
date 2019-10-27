package ie.ul.hbs2.rooms;

public class RoomBuilder {
    public Room addSingleRoom(int roomNumber, int hotelId){
        Room room = new Room(roomNumber, new SingleRoom(), true, hotelId);
        return room;
    }

    public Room addDoubleRoom(int roomNumber, int hotelId){
        Room room = new Room(roomNumber, new DoubleRoom(), true, hotelId);
        return room;
    }

    public Room addKingRoom(int roomNumber, int hotelId){
        Room room = new Room(roomNumber, new KingRoom(), true, hotelId);
        return room;
    }
}
