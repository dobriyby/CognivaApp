package by.pstlabs.cognive.microservices.notifications.controller.rest;

import by.pstlabs.cognive.microservices.notifications.service.PushService;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/push")
public class PushController {

    @Autowired
    private PushService pushService;

    @Autowired
    private ListsService listsService;
    
    @PostMapping("/AddPushForAllUser")
    ResponseEntity<Object> addPush(@RequestParam String sendDate,
                   @RequestParam String text) throws ParseException {
        return pushService.addPushToAll(new SimpleDateFormat("dd/MM/yyyy").parse(sendDate), text);
    }

    @PostMapping("/AddPushToUserName")
    ResponseEntity<Object> addPush(@RequestParam String sendDate, @RequestParam String name,
                                   @RequestParam String text) throws ParseException {

         return pushService.addPushToUserName(new SimpleDateFormat("dd/MM/yyyy").parse(sendDate), name, text);
    }

    @PostMapping("/AddList")
    void addPush(@RequestParam String title, @RequestParam long id) {
        Lists list = new Lists();
        list.setId(id);
        list.setTitle(title);
        listsService.createLists(list);
    }
}
