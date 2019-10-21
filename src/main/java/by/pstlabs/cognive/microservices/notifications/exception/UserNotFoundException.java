package by.pstlabs.cognive.microservices.notifications.exception;

import by.pstlabs.cognive.microservices.notifications.model.ApiResponse;
import by.pstlabs.cognive.microservices.notifications.model.ResponseSignature;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Bahdan Prykhodzka
 */

public class UserNotFoundException extends RuntimeException implements ResponseSignature {

    private ApiResponse apiResponse = new ApiResponse();

    public UserNotFoundException(){
        apiResponse.setCode(-1);
        apiResponse.setMessage("User not found");
        apiResponse.setStatus(HttpStatus.NOT_FOUND);
    }

    public UserNotFoundException(HttpStatus status, String message, int code, List<String> errors) {
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

