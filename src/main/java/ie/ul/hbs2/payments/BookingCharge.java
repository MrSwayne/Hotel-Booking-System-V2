package ie.ul.hbs2.payments;

import ie.ul.hbs2.booking.Booking;

import java.util.UUID;

public class BookingCharge {

    public String ID;
    public Booking booking;

    private String receipt;

    public BookingCharge(Booking Booking ) {
        this.booking = booking;
        this.ID = generateKey();
    }

    public static String generateKey() {
        return UUID.randomUUID().toString();
    }

    public double getCharge() {
        return this.booking.calculateTotalSpent();
    }

    public String getCustomerName() {
        return this.booking.getFirstName() + " " + this.booking.getLastName();
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getReceipt() {
        return this.receipt;
    }

}
