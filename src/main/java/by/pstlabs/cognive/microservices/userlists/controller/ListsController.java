package by.pstlabs.cognive.microservices.userlists.controller;

import by.pstlabs.cognive.logging.LifecycleLoggedBean;
import by.pstlabs.cognive.microservices.userlists.model.UserList;
import by.pstlabs.cognive.microservices.userlists.service.ListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Stepan Novikov
 */
@RestController
@RequestMapping(value = "/userlists", produces = MediaType.APPLICATION_JSON_VALUE)
public class ListsController implements LifecycleLoggedBean {

    public final ListService listService;

    @Autowired
    public ListsController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping(value = "/create")
    public UserList createUserList() throws Exception{
        return listService.createUserList();
    }

    @GetMapping(value = "/{listId:\\d+}")
    public UserList getUserlist(@PathVariable int listId) throws Exception {
        return listService.getUserList(listId);
    }

    @GetMapping(value = "")
    public Iterable<UserList> getUserlists() throws Exception {
        return listService.getUserLists();
    }


}
