package ie.ul.hbs2.payments;
import java.util.LinkedList;


public class PaymentDispatcher {

    private final LinkedList<PaymentMethod> methods = new LinkedList<PaymentMethod>();
    private BookingCharge charge;

    public void addPaymentMethod(PaymentMethod method) {
        this.methods.add(method);
    }

    public void removePaymentMethod(PaymentMethod method) {
        this.methods.remove(method);
    }

    public void processPayment() {

    }

    public void setTarget(BookingCharge charge) {
        this.charge = charge;
    }
}