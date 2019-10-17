package by.pstlabs.cognive.microservices.userlists.model;

/**
 * @author Stepan Novikov
 */
public class ErrorInfo {
    private String message;

    public ErrorInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
