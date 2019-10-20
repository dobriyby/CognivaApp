package by.pstlabs.cognive.microservices.notifications.exception;

import by.pstlabs.cognive.microservices.notifications.model.ApiError;

/**
 * @author Bahdan Prykhodzka
 */

public interface ExceptionSignature {
    ApiError getException();
}
