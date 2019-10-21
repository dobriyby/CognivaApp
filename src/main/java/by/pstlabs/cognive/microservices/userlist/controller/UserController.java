package by.pstlabs.cognive.microservices.userlist.controller;


import by.pstlabs.cognive.microservices.userlist.exception.ResourceNotFoundException;
import by.pstlabs.cognive.microservices.userlist.model.User;
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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/lists/{listsId}/users")
    public ResponseEntity<List<User>> getAllUsersByListsId(@PathVariable (value = "listsId") Long listsId) {
        List<User> users = userService.getAllUserByListsId(listsId);
        return new ResponseEntity<>(users, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/lists/{listsId}/users")
    public ResponseEntity<User> createUsers(@PathVariable (value = "listsId") Long listsId,
                                 @Valid @RequestBody User user) throws ResourceNotFoundException {
        User u = userService.createUser(listsId,user);
        return new ResponseEntity<>(u, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/lists/{listsId}/users/{userId}")
    public ResponseEntity<User> updateUsers(@PathVariable (value = "listsId") Long listsId,
                                 @PathVariable (value = "userId") Long userId,
                                 @Valid @RequestBody User userRequest) throws ResourceNotFoundException {
        User update = userService.updateUser(listsId,userId,userRequest);
        return new ResponseEntity<>(update,new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/lists/{listsId}/users/{userId}")
    public HttpStatus deleteUser(@PathVariable (value = "listsId") Long listsId,
                                           @PathVariable (value = "userId") Long userId) throws ResourceNotFoundException {
        userService.deleteUser(listsId,userId);
        return HttpStatus.OK;
    }

    @PostMapping("/user/create")
    public HttpStatus createUser(@RequestParam String name, @RequestParam String email){
        userService.createUserByNameAndEmail(name, email);
        return  HttpStatus.OK;
    }



}
