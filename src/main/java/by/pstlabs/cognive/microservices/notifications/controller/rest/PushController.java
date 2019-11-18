package by.pstlabs.cognive.microservices.notifications.controller.rest;

import by.pstlabs.cognive.microservices.notifications.model.Push;
import by.pstlabs.cognive.microservices.notifications.model.PushRequest;
import by.pstlabs.cognive.microservices.notifications.service.PushService;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.service.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin
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

    @PostMapping(value = "/AddPushToUserName",produces = "application/json")
    ResponseEntity<Object> addPush(@RequestBody PushRequest push) throws ParseException {
        return pushService.addPushToUserName(new SimpleDateFormat("yyyy-MM-dd").parse(push.sendDate), push.name, push.text, push.title);
    }

    @PostMapping("/AddList")
    void addPush(@RequestParam String name) {
        listsService.create(new Lists(name));
    }

    @GetMapping("/all")
    List<Push> addPush() {
        return pushService.getAllPushes();
    }
}
