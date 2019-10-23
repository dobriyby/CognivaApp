package by.pstlabs.cognive.microservices.notifications.service;

import by.pstlabs.cognive.microservices.notifications.exception.UnableToSendNotificationException;
import by.pstlabs.cognive.microservices.notifications.model.ApiResponse;
import by.pstlabs.cognive.microservices.notifications.model.MailNotificationRequest;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Bahdan Prykhodzka
 */

@Service
public class MailerSender implements MailerSenderService {

    private Mailer mailer;

    @Value("${smtp.server}")
    private String server;

    @Value("${smtp.port}")
    private int port;

    @Value("${sender.email}")
    private String senderMail;

    @Value("${sender.email.password}")
    private String password;


    @Override
    public ResponseEntity<Object> SendMail(MailNotificationRequest mailNotificationRequest) {
        Email email = EmailBuilder.startingBlank()
                .from("it`s FROM", "zxas.1996@mail.com")
                .withSubject(mailNotificationRequest.getTheme())
                .to(mailNotificationRequest.getName(), mailNotificationRequest.getEmail())
                .withPlainText(mailNotificationRequest.getText())
                .buildEmail();
        return send(email);
    }

    @Override
    public ResponseEntity<Object> SendMails(List<MailNotificationRequest> mailNotificationRequestList) {
        ApiResponse apiResponse =
                new ApiResponse(HttpStatus.SERVICE_UNAVAILABLE, "", -1, "");
        return new ResponseEntity<>(
                apiResponse, new HttpHeaders(), apiResponse.getStatus());
    }

    private ResponseEntity<Object> send(Email email) {
        try {
            mailer.sendMail(email);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new UnableToSendNotificationException();
        }
        ApiResponse apiResponse =
                new ApiResponse(HttpStatus.OK, "Mail accepted for delivery", 0, "");
        return new ResponseEntity<>(
                apiResponse, new HttpHeaders(), apiResponse.getStatus());
    }

    @PostConstruct
    private void configuration() {
        System.out.println(server + "1");
        mailer = MailerBuilder
                .withSMTPServer(server, port, senderMail, password)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withSessionTimeout(10 * 1000)
                .clearEmailAddressCriteria() // turns off email validation
                .buildMailer();
    }
}
