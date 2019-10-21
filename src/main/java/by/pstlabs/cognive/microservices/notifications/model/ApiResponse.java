package by.pstlabs.cognive.microservices.notifications.model;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Bahdan Prykhodzka
 */

public class ApiResponse {
    private HttpStatus status;
    private int code;
    private String message;
    private List<String> errors;
    private String date = new Date().toString();

    public ApiResponse() {
    }

    public ApiResponse(HttpStatus status, String message, int code, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.code = code;
    }

    public ApiResponse(HttpStatus status, String message, int code, String error) {
        super();
        this.status = status;
        this.message = message;
        this.code = code;
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

    public String getDate() {
        return date;
    }

    public int getCode() {
        return code;
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

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status=" + status +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                ", date='" + date + '\'' +
                '}';
    }
}
