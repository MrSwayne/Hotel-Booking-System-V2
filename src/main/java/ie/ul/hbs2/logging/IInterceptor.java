package ie.ul.hbs2.logging;

public interface IInterceptor {
    public void preLoginReply(ContextObject context);
    public void postLogoutReply(ContextObject context);
}
