package ie.ul.hbs2.payments;

import ie.ul.hbs2.booking.Booking;

public class BookingCharge {

    Booking[] bookings;
    PaymentMethod paymentMethod;

    public BookingCharge(PaymentMethod m, Booking ... bookings ) {
        this.bookings = bookings;
        this.paymentMethod = m;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }


    public void setReceipt() {

    }
}
