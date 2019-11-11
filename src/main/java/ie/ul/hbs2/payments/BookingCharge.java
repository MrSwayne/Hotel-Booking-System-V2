package ie.ul.hbs2.payments;

import java.util.UUID;

public class BookingCharge {

    public double amount;
    public String ID;

    private String receipt;

    public BookingCharge(double amount ) {
        this.amount = amount;
        this.ID = generateKey();
    }

    public static String generateKey() {
        return UUID.randomUUID().toString();
    }


    public void setReceipt(String receipt) {

    }

    public float get_cost() {
        int price = 0;

        return price;
    }

    public String getReceipt() {
        return this.receipt;
    }

}
