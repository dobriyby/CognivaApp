package by.pstlabs.cognive.microservices.notifications.model;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Bahdan Prykhodzka
 */

public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;
    private String errorDate = new Date().toString();

    public ApiError() {
    }

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Collections.singletonList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getErrorDate() {
        return errorDate;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                ", errorDate=" + errorDate +
                '}';
    }
}
