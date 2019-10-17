package by.pstlabs.cognive.microservices.lists;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ListController {

    @GetMapping("/echo")
    private String echo(){
        return "I`m alive! Current time is " + new Date();
    }
}
