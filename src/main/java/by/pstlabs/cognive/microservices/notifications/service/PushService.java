package by.pstlabs.cognive.microservices.notifications.service;

import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface PushService {

    void checkSendTimePush();
    ResponseEntity<Object> addPushToAll(Date date, String text);
    ResponseEntity<Object> addPushToUserName(Date date, String name, String text);

}
