package by.pstlabs.cognive.microservices.notifications.service;

/**
 * @author Bahdan Prykhodzka
 */

public interface MailerSenderService {
    String SendMail(String mail, String name, String text);
}
