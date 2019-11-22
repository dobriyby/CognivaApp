package by.pstlabs.cognive.microservices.userlist.controller;


import by.pstlabs.cognive.common.exception.ResourceNotFoundException;
import by.pstlabs.cognive.common.model.Role;
import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.userlist.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Stepan Novikov
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/users/create")
    public HttpStatus createUser(@RequestBody User user) {
        userService.createUser(user);
        return  HttpStatus.OK;
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable (value = "userId") Long userId,
                                           @Valid @RequestBody User userRequest) throws ResourceNotFoundException {
        User update = userService.updateUser(userId, userRequest);
        return new ResponseEntity<>(update,new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/roles/create")
    public HttpStatus createRole(@RequestBody String name){
        userService.createRole(name);
        return HttpStatus.OK;
    }

    @GetMapping("/roles")
    public List<Role> listRoles() {
        return userService.listRoles();
    }

    }
