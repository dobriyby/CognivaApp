package by.pstlabs.cognive.microservices.notifications.service;

import java.util.Date;

public interface PushService {

    void checkSendTimePush();
    String addPushToAll(Date date, String text);
    String addPushToUserName(Date date, String name, String text);

}
