package ie.ul.hbs2.logging;

public interface IInterceptorCallback {

    public void doWork();
    public void workDone(boolean successful);
}
