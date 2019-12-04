package by.pstlabs.cognive.microservices.notifications.model;

public class MailNotificationRequest {

    private String email;
    private String theme;
    private String name;
    private String text;

    public MailNotificationRequest(String email, String theme, String name, String text) {
        this.email = email;
        this.theme = theme;
        this.name = name;
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public String getTheme() {
        return theme;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "email='" + email + '\'' +
                ", theme='" + theme + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
