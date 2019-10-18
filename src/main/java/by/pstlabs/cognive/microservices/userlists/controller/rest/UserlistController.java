package by.pstlabs.cognive.microservices.userlists.controller.rest;

import by.pstlabs.cognive.logging.LifecycleLoggedBean;
import by.pstlabs.cognive.microservices.userlists.model.Userlist;
import by.pstlabs.cognive.microservices.userlists.service.UserlistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Stepan Novikov
 */
@RestController
@RequestMapping(value = "/userlists", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserlistController implements LifecycleLoggedBean {

    public final UserlistService listService;

    @Autowired
    public UserlistController(@Qualifier("userlistServiceInMemory") UserlistService listService) {
        this.listService = listService;
    }

    @PostMapping(value = "/create")
    public Userlist createUserList() throws Exception{
        return listService.createUserlist();
    }

    @GetMapping(value = "/{listId:\\d+}")
    public Userlist getUserlist(@PathVariable int listId) throws Exception {
        return listService.getUserlist(listId);
    }

    @GetMapping(value = "")
    public Iterable<Userlist> getUserlists() throws Exception {
        return listService.getUserlists();
    }


}
