package ie.ul.hbs2.logging;

import java.util.LinkedList;

public class LoggingDispatcher implements IInterceptor {

    private final LinkedList<IInterceptor> interceptors = new LinkedList<>();
    //private ContextObject contextObject;
    private static LoggingDispatcher dispatcher;

    public void registerInterceptor(IInterceptor interceptor) {
        this.interceptors.add(interceptor);
    }

    public void removeInterceptor(IInterceptor interceptor) {
        this.interceptors.remove(interceptor);
    }

    public Iterable<IInterceptor> getInterceptors() {
        return this.interceptors;
    }

    @Override
    public void preLoginReply(ContextObject context) {
        IInterceptor interceptor = interceptors.get(interceptors.size() - 1);
        interceptor.preLoginReply(context);
    }

    @Override
    public void postLogoutReply(ContextObject context) {
        IInterceptor interceptor = interceptors.get(interceptors.size() - 1);
        interceptor.postLogoutReply(context);
    }


}
