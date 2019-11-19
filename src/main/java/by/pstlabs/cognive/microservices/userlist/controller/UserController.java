package by.pstlabs.cognive.microservices.userlist.controller;


import by.pstlabs.cognive.common.exception.ResourceNotFoundException;
import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.userlist.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/users/create")
    public HttpStatus createUser(@RequestBody User user){
        userService.createUserByNameAndEmail(user.getName(), user.getEmail());
        return  HttpStatus.OK;
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable (value = "userId") Long userId,
                                           @Valid @RequestBody User userRequest) throws ResourceNotFoundException {
        User update = userService.updateUser(userId, userRequest);
        return new ResponseEntity<>(update,new HttpHeaders(), HttpStatus.OK);
    }

}
