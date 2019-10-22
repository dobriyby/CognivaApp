package by.pstlabs.cognive.microservices.notifications.exception;

import by.pstlabs.cognive.microservices.notifications.model.ApiResponse;
import by.pstlabs.cognive.microservices.notifications.model.ResponseSignature;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Bahdan Prykhodzka
 */

public class UnableToSendNotificationException extends RuntimeException implements ResponseSignature {

    private ApiResponse apiResponse = new ApiResponse();

    public UnableToSendNotificationException() {
        apiResponse.setCode(-1);
        apiResponse.setMessage("Unable to send notification");
        apiResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
    }

    public UnableToSendNotificationException(HttpStatus status, String message, int code, List<String> errors) {
        apiResponse.setStatus(status);
        apiResponse.setMessage(message);
        apiResponse.setCode(code);
        apiResponse.setErrors(errors);
    }

    @Override
    public ApiResponse getResponse() {
        return apiResponse;
    }
}
