package by.pstlabs.cognive.microservices.notifications.controller.rest;

import by.pstlabs.cognive.microservices.notifications.model.MailNotificationRequest;
import by.pstlabs.cognive.microservices.notifications.service.MailerSenderService;
import by.pstlabs.cognive.microservices.notifications.service.PushService;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author Bahdan Prykhodzka
 */

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private MailerSenderService mailerSender;


    @PostMapping("/sendMail")
    public ResponseEntity<Object> sendMailTest(MailNotificationRequest mailNotificationRequest) {
        return mailerSender.SendMail(mailNotificationRequest);
    }

}
