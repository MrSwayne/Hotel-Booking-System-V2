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

    public boolean processPayment() {
        for(PaymentMethod method: this.methods) {
            if (method == this.charge.getPaymentMethod())
                return method.processPayment(this.charge);
        }
        return false;
    }

    public Iterable<PaymentMethod> getMethods() {
        return this.methods;
    }

    public void setCharge(BookingCharge charge) {
        this.charge = charge;
    }
}