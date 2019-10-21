package by.pstlabs.cognive.microservices.notifications.exception;

import by.pstlabs.cognive.microservices.notifications.model.ApiResponse;
import by.pstlabs.cognive.microservices.notifications.model.ResponseSignature;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Bahdan Prykhodzka
 */

public class UserBannedNotificationsException extends RuntimeException implements ResponseSignature {

    private ApiResponse apiResponse = new ApiResponse();

    public UserBannedNotificationsException(){
        apiResponse.setCode(-1);
        apiResponse.setMessage("User banned notification");
        apiResponse.setStatus(HttpStatus.BAD_REQUEST);
    }

    public UserBannedNotificationsException(HttpStatus status, String message, int code, List<String> errors) {
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
