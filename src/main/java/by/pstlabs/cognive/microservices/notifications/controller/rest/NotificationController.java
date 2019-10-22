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
public class NotificationController {

    @Autowired
    private MailerSenderService mailerSender;

    @Autowired
    private PushService pushService;

    @Autowired
    private ListsService listsService;

    @PostMapping("/SendMailTest")
    public ResponseEntity<Object> sendMailTest(MailNotificationRequest mailNotificationRequest) {
        return mailerSender.SendMail(mailNotificationRequest);
    }

    @PostMapping("/AddPushForAllUser")
    String addPush(@RequestParam String sendDate,
                               @RequestParam String text) throws ParseException {

        pushService.addPushToAll(new SimpleDateFormat("dd/MM/yyyy").parse(sendDate), text);
        return "Push success added to database!";
    }

    @PostMapping("/AddPushToUserName")
    String addPush(@RequestParam String sendDate, @RequestParam String name,
                   @RequestParam String text) throws ParseException {

       String result =  pushService.addPushToUserName(new SimpleDateFormat("dd/MM/yyyy").parse(sendDate), name, text);
        return (result=="done"?"Push success added to database!" : "it's a trap!!!");
    }

    @PostMapping("/AddList")
    void addPush(@RequestParam String title, @RequestParam long id) {
        Lists list = new Lists();
        list.setId(id);
        list.setTitle(title);
        listsService.createLists(list);
    }
}
