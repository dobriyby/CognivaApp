package by.pstlabs.cognive.common.login.controller;

import by.pstlabs.cognive.common.login.service.LoginService;
import by.pstlabs.cognive.common.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    boolean login(@RequestBody User user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(user);
        System.out.println(objectMapper.writeValueAsString(user));
        return loginService.checkLogin(user);
    }
}
