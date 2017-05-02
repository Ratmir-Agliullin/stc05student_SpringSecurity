package main.Controllers.Listeners;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Created by admin on 20.04.2017.
 */
public class MySessionListener implements HttpSessionListener {

    private static final Logger LOGGER ;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.debug("Session id = " + httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
