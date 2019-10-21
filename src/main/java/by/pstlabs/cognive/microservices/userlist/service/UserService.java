package by.pstlabs.cognive.microservices.userlist.service;

import by.pstlabs.cognive.microservices.userlist.exception.ResourceNotFoundException;
import by.pstlabs.cognive.microservices.userlist.model.User;
import by.pstlabs.cognive.microservices.userlist.repository.ListsRepository;
import by.pstlabs.cognive.microservices.userlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


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


    public List<User> getAllUserByListsId(Long listsId) {
        return userRepository.findByListsId(listsId);
    }

    public User createUser(Long listsId,User user) throws ResourceNotFoundException {
        return listsRepository.findById(listsId).map(list -> {
            user.setUserlist(list);
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }

    public User updateUser(Long listsId,Long userId, User userRequest) throws ResourceNotFoundException {
        if(!listsRepository.existsById(listsId)) {
            throw new ResourceNotFoundException("ListsId " + listsId + " not found");
        }

        return userRepository.findById(userId).map(user -> {
            user.setName(userRequest.getName());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("UsertId " + userId + "not found"));
    }


    public HttpStatus deleteUser(Long listsId, Long userId) throws ResourceNotFoundException {
        return userRepository.findByIdAndListsId(userId, listsId).map(user -> {
            userRepository.delete(user);
            return HttpStatus.OK;
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId + " and listsId " + listsId));
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
