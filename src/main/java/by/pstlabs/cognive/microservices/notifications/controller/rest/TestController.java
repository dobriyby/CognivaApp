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
public class TestController {
    //Created to test exception
    @RequestMapping("/testException")
    public String test(@RequestParam int id) {
        switch (id) {
            case (1):
                throw new UnableToSendNotificationException();
            case (2):
                throw new UserBannedNotificationsException();
            case (3):
                throw new UserNotFoundException();
        }
        return "no exception";
    }
}
