package by.pstlabs.cognive.microservices.notifications.controller.rest;

import by.pstlabs.cognive.microservices.notifications.model.MailNotificationRequest;
import by.pstlabs.cognive.microservices.notifications.service.MailerSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Bahdan Prykhodzka
 */

@RestController
public class NotificationController {

    @Autowired
    private MailerSenderService mailerSender;

    @PostMapping("/SendMailTest")
    public ResponseEntity<Object> sendMailTest(MailNotificationRequest mailNotificationRequest) {
        return mailerSender.SendMail(mailNotificationRequest);
    }
}
