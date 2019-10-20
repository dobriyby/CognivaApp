package by.pstlabs.cognive.microservices.notifications.controller;

import by.pstlabs.cognive.microservices.notifications.exception.ExceptionSignature;
import by.pstlabs.cognive.microservices.notifications.exception.UnableToSendNotificationException;
import by.pstlabs.cognive.microservices.notifications.exception.UserBannedNotificationsException;
import by.pstlabs.cognive.microservices.notifications.exception.UserNotFoundException;
import by.pstlabs.cognive.microservices.notifications.model.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

/**
 * @author Bahdan Prykhodzka
 */

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    //Default exception handler
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex) {
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    //UserExceptionHandler
    @ExceptionHandler({UserNotFoundException.class,
            UserBannedNotificationsException.class,
            UnableToSendNotificationException.class})
    public ResponseEntity<Object> handleUserNotFoundException(ExceptionSignature ex) {
        return new ResponseEntity<>(
                ex.getException(), new HttpHeaders(), ex.getException().getStatus());
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
            MethodArgumentTypeMismatchException ex) {
        String error =
                ex.getName() + " should be of type " + Objects.requireNonNull(ex.getRequiredType()).getName();

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }


}
