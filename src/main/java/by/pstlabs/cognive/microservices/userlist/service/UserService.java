package by.pstlabs.cognive.microservices.userlist.service;

import by.pstlabs.cognive.microservices.userlist.exception.ResourceNotFoundException;
import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.userlist.repository.ListsRepository;
import by.pstlabs.cognive.microservices.userlist.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Stepan Novikov
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ListsRepository listsRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userUpdated) throws ResourceNotFoundException {
        return userRepository.findById(userId).map((user) -> {
            user.setEmail(userUpdated.getEmail());
            user.setName(userUpdated.getName());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("user", userId));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findById(Long userId) throws ResourceNotFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", userId));
    }

    public User createUserByNameAndEmail(String name,String email) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
//        user.setLists(listsRepository.findAll().get(0));
        return userRepository.save(user);
    }

//    public List<User> getAllUsers() {
//
//        List<User> userList = userRepository.findAll();
//
//        if(userList.size() > 0 ) {
//            return userList;
//        } else {
//            return new ArrayList<User>();
//        }
//    }
//
//    public User getUserById(Long id) throws RecordNotFoundException {
//        Optional<User> user = userRepository.findById(id);
//
//        if (user.isPresent()) {
//            return user.get();
//        } else {
//            throw new RecordNotFoundException("No employee record exist for given id");
//        }
//    }
//
//    public User createOrUpdateUser(User userEntity) throws RecordNotFoundException{
//        Optional<User> user = userRepository.findById(userEntity.getId());
//
//        if(user.isPresent()) {
//            User newUser = user.get();
//            newUser.setName(userEntity.getName());
//
//            newUser = userRepository.save(userEntity);
//
//            return newUser;
//        } else {
//            userEntity = userRepository.save(userEntity);
//
//            return userEntity;
//        }
//    }
//
//    public void deleteUserById(Long id) throws RecordNotFoundException {
//        Optional<User> user = userRepository.findById(id);
//
//        if(user.isPresent()) {
//            userRepository.deleteById(id);
//        } else {
//            throw new RecordNotFoundException("No employee record exist for given id");
//        }
//    }
}
