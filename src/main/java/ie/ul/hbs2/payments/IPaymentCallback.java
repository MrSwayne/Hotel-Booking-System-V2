package ie.ul.hbs2.payments;

public interface IPaymentCallback {

    public void doWork();
    public void workDone(boolean successful);
}
