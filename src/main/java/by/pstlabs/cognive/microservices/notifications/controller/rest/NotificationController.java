package by.pstlabs.cognive.microservices.notifications.controller.rest;

import by.pstlabs.cognive.microservices.notifications.exception.UnableToSendNotificationException;
import by.pstlabs.cognive.microservices.notifications.exception.UserBannedNotificationsException;
import by.pstlabs.cognive.microservices.notifications.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bahdan Prykhodzka
 */

@RestController
public class NotificationController {

    //Created to test exception handler
    @RequestMapping("testEx")
    public String test(@RequestParam int id) {
        switch (id) {
            case (1):
                throw new UnableToSendNotificationException("Message, Unable to Send Notification exception", HttpStatus.FORBIDDEN);
            case (2):
                throw new UserBannedNotificationsException("Message, User banned notification exception", HttpStatus.BAD_GATEWAY);
            case (3):
                throw new UserNotFoundException("Message, User not found exception", HttpStatus.NOT_FOUND);
        }
        return "no exception";
    }
}
