package by.pstlabs.cognive.microservices.userlists.controller.rest;
import by.pstlabs.cognive.microservices.userlists.model.ErrorInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Stepan Novikov
 */

@ControllerAdvice
public class ErrorController {

    private Logger logger =  LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo processException(Exception e) {
        logger.error("Unexpected error " + e);
        return new ErrorInfo(e.getMessage());
    }

}