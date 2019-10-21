package by.pstlabs.cognive.microservices.userlist.controller;

import by.pstlabs.cognive.microservices.userlist.exception.ResourceNotFoundException;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.service.ListsService;
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
public class ListsController {

    @Autowired
    private ListsService listsService;

    @GetMapping("/lists")
    public ResponseEntity<List<Lists>> getAllLists() {
        List<Lists> list = listsService.getAllLists();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/lists")
    public ResponseEntity<Lists> createLists(@Valid @RequestBody Lists lists) {
        Lists create = listsService.createLists(lists);

        return new ResponseEntity<>(create, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/lists/{listsId}")
    public ResponseEntity<Lists> updateLists(@PathVariable(value = "listsId") Long listsId,
                                             @Valid @RequestBody Lists listRequest) throws ResourceNotFoundException {
        Lists update = listsService.updateLists(listsId, listRequest);

        return new ResponseEntity<>(update, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/lists/{listsId}")
    public HttpStatus deleteLists(@PathVariable(value = "listsId") Long listsId) throws ResourceNotFoundException {

        listsService.deleteLists(listsId);
        return HttpStatus.OK;
    }


}
