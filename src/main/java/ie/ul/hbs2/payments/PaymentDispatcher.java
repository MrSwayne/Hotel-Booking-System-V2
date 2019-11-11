package ie.ul.hbs2.payments;
import java.util.LinkedList;


public class PaymentDispatcher {

    private final LinkedList<IPaymentMethod> methods = new LinkedList<IPaymentMethod>();
    private BookingCharge charge;

    public void addPaymentMethod(IPaymentMethod method) {
        this.methods.add(method);
    }

    public void removePaymentMethod(IPaymentMethod method) {
        this.methods.remove(method);
    }


    public Iterable<IPaymentMethod> getMethods() {
        return this.methods;
    }

    public void setCharge(BookingCharge charge) {
        this.charge = charge;
    }
}