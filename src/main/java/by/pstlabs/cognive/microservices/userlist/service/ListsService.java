package by.pstlabs.cognive.microservices.userlist.service;

import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.common.exception.ResourceNotFoundException;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.repository.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stepan Novikov
 */

@Service
public class ListsService extends BaseService<Lists>{

    @Autowired
    private ListsRepository listsRepository;

    @Autowired
    private UserService userService;

    public Lists updateLists(Long listsId, Lists listRequest) throws ResourceNotFoundException {
        return listsRepository.findById(listsId).map(list -> {
            list.setName(listRequest.getName());
            return listsRepository.save(list);
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }

    public HttpStatus deleteLists(Long listsId) throws ResourceNotFoundException {
        return listsRepository.findById(listsId).map(list -> {
            listsRepository.delete(list);
            return HttpStatus.OK;
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }

    public List<User> getAllUserByListsId(Long listsId) throws ResourceNotFoundException {
        return listsRepository.findById(listsId).map(list -> {
            return new ArrayList<>(list.getUserSet());
        }).orElseThrow(() -> new ResourceNotFoundException("List not found with id " + listsId));
    }

    public User addUser(Long listsId, User user) throws ResourceNotFoundException {
        return listsRepository.findById(listsId).map(list -> {
            list.addUser(userService.createUser(user));
            listsRepository.save(list);
            return user;
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }

    public HttpStatus deleteUser(Long listsId, Long userId) throws ResourceNotFoundException {
        User user = userService.findById(userId);
        return listsRepository.findById(listsId).map(list -> {
            list.deleteUser(user);
            listsRepository.save(list);
            return HttpStatus.OK;
        }).orElseThrow(() -> new ResourceNotFoundException("List not found with id " + listsId));
    }

    public boolean isUserInList(Long listsId, User user) throws ResourceNotFoundException {
        return listsRepository.findById(listsId).map((list) -> {
            return list.getUserSet().contains(user);
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }
}
