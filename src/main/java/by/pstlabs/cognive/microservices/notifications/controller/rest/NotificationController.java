package by.pstlabs.cognive.microservices.notifications.controller.rest;

import by.pstlabs.cognive.microservices.notifications.service.MailerSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.*;


/**
 * @author Bahdan Prykhodzka
 */

@RestController
public class NotificationController {

    @Autowired
    private MailerSenderService mailerSender;

    @PostMapping("/SendMailTest")
    public String sendMailTest(@RequestParam String mailReceiver,
                               @RequestParam String receiverName,
                               @RequestParam String text) {
        return mailerSender.SendMail(mailReceiver, receiverName, text);
    }
}
