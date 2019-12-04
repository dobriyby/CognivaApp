package by.pstlabs.cognive.microservices.notifications.exception;

import by.pstlabs.cognive.microservices.notifications.model.ApiResponse;
import by.pstlabs.cognive.microservices.notifications.model.ResponseSignature;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

/**
 * @author Bahdan Prykhodzka
 */

public class CustomException extends RuntimeException implements ResponseSignature {

    private ApiResponse apiResponse = new ApiResponse();


    public CustomException(HttpStatus status) {
        apiResponse.setStatus(status);
    }

    public CustomException(HttpStatus status, String message) {
        apiResponse.setStatus(status);
        apiResponse.setMessage(message);
    }

    public CustomException(HttpStatus status, String message, int code, String errors) {
        apiResponse.setStatus(status);
        apiResponse.setMessage(message);
        apiResponse.setCode(code);
        apiResponse.setErrors(Collections.singletonList(errors));
    }

    public CustomException(HttpStatus status, String message, int code, List<String> errors) {
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
