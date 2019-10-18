package by.pstlabs.cognive.microservices.userlists.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class EchoController {

    @GetMapping("/")
    private String echo(){
        return "I`m alive! Current moment is " + new Date();
    }

}
