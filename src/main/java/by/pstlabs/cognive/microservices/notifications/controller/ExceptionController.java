package by.pstlabs.cognive.microservices.notifications.controller;

import by.pstlabs.cognive.microservices.notifications.model.ResponseSignature;
import by.pstlabs.cognive.microservices.notifications.exception.UnableToSendNotificationException;
import by.pstlabs.cognive.microservices.notifications.exception.UserBannedNotificationsException;
import by.pstlabs.cognive.microservices.notifications.exception.UserNotFoundException;
import by.pstlabs.cognive.microservices.notifications.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

/**
 * @author Bahdan Prykhodzka
 */

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    //Default exception handler
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex) {
        ApiResponse apiResponse = new ApiResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), -1,"INTERNAL_SERVER_ERROR");
        logger.error(apiResponse.toString());
        return new ResponseEntity<>(
                apiResponse, new HttpHeaders(), apiResponse.getStatus());
    }

    //UserExceptionHandler
    @ExceptionHandler({UserNotFoundException.class,
            UserBannedNotificationsException.class,
            UnableToSendNotificationException.class})
    public ResponseEntity<Object> handleUserNotFoundException(ResponseSignature ex) {
        logger.error(ex.getResponse().toString());
        return new ResponseEntity<>(
                ex.getResponse(), new HttpHeaders(), ex.getResponse().getStatus());
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex) {
        String error =
                ex.getName() + " should be of type " + Objects.requireNonNull(ex.getRequiredType()).getName();
        ApiResponse apiResponse =
                new ApiResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), -1, error);
        logger.error(apiResponse.toString());
        return new ResponseEntity<>(
                apiResponse, new HttpHeaders(), apiResponse.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatus status,
            @NonNull WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";
        ApiResponse apiResponse =
                new ApiResponse(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),-1, error);
        logger.error(apiResponse.toString());
        return new ResponseEntity<>(
                apiResponse, new HttpHeaders(), apiResponse.getStatus());
    }

}
