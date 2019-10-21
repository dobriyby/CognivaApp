package by.pstlabs.cognive.microservices.notifications.service;

import by.pstlabs.cognive.microservices.userlist.model.User;

import java.util.Date;
import java.util.List;

public interface PushService {

    void checkSendTimePush();
    String addPushToAll(Date date, String text);
    String addPushToUserName(Date date, String name, String text);

}
