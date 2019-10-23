package by.pstlabs.cognive.microservices.userlist.service;

import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.userlist.exception.ResourceNotFoundException;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.repository.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stepan Novikov
 */

@Service
public class ListsService {

    @Autowired
    private ListsRepository listsRepository;

    public List<Lists> getAllLists() {
        return listsRepository.findAll();
    }

    public Lists createLists(String listName){
        return this.createLists(new Lists(listName));
    }

    public Lists createLists(Lists lists) {
        return listsRepository.save(lists);
    }

    public Lists updateLists(Long listsId, Lists listRequest) throws ResourceNotFoundException {
        return listsRepository.findById(listsId).map(list -> {
            list.setTitle(listRequest.getTitle());
            return listsRepository.save(list);
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }

    public HttpStatus deleteLists(Long listsId) throws ResourceNotFoundException {
        return listsRepository.findById(listsId).map(list -> {
            listsRepository.delete(list);
            return HttpStatus.OK;
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }

    public boolean isUserInList(Long listsId, User user) throws ResourceNotFoundException {
        return listsRepository.findById(listsId).map((list) -> {
            return list.getUserSet().contains(user);
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }
}
