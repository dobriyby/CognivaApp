package by.pstlabs.cognive.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Stepan Novikov
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    private static final String msgTemplate = "%s with id %d not found!";
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable t) {
        super(message, t);
    }

    public ResourceNotFoundException(String resourceName, Long resourceId){
        super(String.format(msgTemplate, resourceName, resourceId));
    }
    public ResourceNotFoundException(Long resourceId){
        this("resource", resourceId);
    }

}
