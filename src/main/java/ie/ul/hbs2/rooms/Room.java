package ie.ul.hbs2.rooms;

abstract class Room {
    private int roomNumber;
    private boolean available = true;
    private double price = 0.0;
    private int hotelId;

    Room(int roomNumber, RoomType roomType, boolean available, double price, int hotelId) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.available = available;
        this.price = price;
        this.hotelId = hotelId;
    }

    RoomType roomType = null;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public int getHotelId() {
        return hotelId;
    }
}
