package by.pstlabs.cognive.microservices.notifications.service;

import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.notifications.model.Push;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface PushService {

    void checkSendTimePush();
    ResponseEntity<Object> addPushToAll(Date date, String text);
    ResponseEntity<Object> addPushToUserName(Date date, String name, String text, String title);
    List<Push> getAllPushes();

}
