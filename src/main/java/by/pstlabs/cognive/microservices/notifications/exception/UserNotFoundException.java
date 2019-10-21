package by.pstlabs.cognive.microservices.notifications.exception;

import by.pstlabs.cognive.microservices.notifications.model.ApiError;
import org.springframework.http.HttpStatus;

/**
 * @author Bahdan Prykhodzka
 */

public class UserNotFoundException extends RuntimeException implements ExceptionSignature {

    private ApiError apiError = new ApiError();

    public UserNotFoundException(){
        apiError.setMessage("User not found");
        apiError.setStatus(HttpStatus.NOT_FOUND);
    }

    public UserNotFoundException(String message, HttpStatus status) {
        apiError.setMessage(message);
        apiError.setStatus(status);
    }

    @Override
    public ApiError getException() {
        return apiError;
    }
}

