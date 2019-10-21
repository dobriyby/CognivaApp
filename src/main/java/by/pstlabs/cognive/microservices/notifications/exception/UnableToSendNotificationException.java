package by.pstlabs.cognive.microservices.notifications.exception;

import by.pstlabs.cognive.microservices.notifications.model.ApiError;
import org.springframework.http.HttpStatus;

/**
 * @author Bahdan Prykhodzka
 */

public class UnableToSendNotificationException extends RuntimeException implements ExceptionSignature {

    private ApiError apiError = new ApiError();

    public UnableToSendNotificationException() {
        apiError.setMessage("Unable to send notification");
        apiError.setStatus(HttpStatus.BAD_GATEWAY);
    }

    public UnableToSendNotificationException(String message, HttpStatus status) {
        apiError.setMessage(message);
        apiError.setStatus(status);
    }

    @Override
    public ApiError getException() {
        return apiError;
    }
}
