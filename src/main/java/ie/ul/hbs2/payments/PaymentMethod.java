package ie.ul.hbs2.payments;

public abstract class PaymentMethod {

    String API_KEY;

    public abstract boolean processPayment(BookingCharge bookingCharge);
}
