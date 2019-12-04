package by.pstlabs.cognive.microservices.notifications.controller.rest;

import by.pstlabs.cognive.microservices.notifications.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bahdan Prykhodzka
 */

@RestController
public class TestController {
    //Created to test exception
    @RequestMapping("/testException")
    public String test(@RequestParam int id) {
        switch (id) {
            case (1):
                throw new CustomException(HttpStatus.BAD_GATEWAY, "Custom  - Bad gateway", -1 , "");
            case (2):
                throw new CustomException(HttpStatus.BAD_REQUEST, "Custom - Bad request");
            case (3):
                throw new CustomException(HttpStatus.OK);
        }
        return "no exception";
    }
}
