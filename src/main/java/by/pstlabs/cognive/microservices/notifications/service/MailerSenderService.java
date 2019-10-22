package by.pstlabs.cognive.microservices.notifications.service;

import by.pstlabs.cognive.microservices.notifications.model.MailNotificationRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Bahdan Prykhodzka
 */

public interface MailerSenderService {


    ResponseEntity<Object> SendMail(MailNotificationRequest mailNotificationRequest);

    ResponseEntity<Object> SendMails(List<MailNotificationRequest> mailNotificationRequestList);

}
