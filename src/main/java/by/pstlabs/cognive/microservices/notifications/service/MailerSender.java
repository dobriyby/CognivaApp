package by.pstlabs.cognive.microservices.notifications.service;

import by.pstlabs.cognive.microservices.notifications.exception.UnableToSendNotificationException;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.beans.factory.annotation.Value;


import javax.annotation.PostConstruct;

/**
 * @author Bahdan Prykhodzka
 */


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
    public String SendMail(String mail, String name, String text) {
        Email email = EmailBuilder.startingBlank()
                .from("Bogdan", "bonusbyout@gmail.com") //TODO: test custom address with google service
                .to(name, mail)
                .withPlainText(text)
                .buildEmail();
        try {
            mailer.sendMail(email);
        } catch (Exception ex) {
            throw new UnableToSendNotificationException();
        }
        return "MailSend"; //TODO: make answer
    }

    @PostConstruct
    public void configuration() {
        System.out.println(server);
        mailer = MailerBuilder
                .withSMTPServer(server, port, senderMail, password)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withSessionTimeout(10 * 1000)
                .clearEmailAddressCriteria() // turns off email validation
                .buildMailer();
    }
}
