package by.pstlabs.cognive.microservices.notifications.controller.rest;

import by.pstlabs.cognive.microservices.notifications.model.Push;
import by.pstlabs.cognive.microservices.notifications.service.PushService;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
import by.pstlabs.cognive.microservices.userlist.service.ListsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/push")
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

    @PostMapping(value = "/AddPushToUserName")
    ResponseEntity<Object> addPush(@RequestBody Map<String, String> body) throws ParseException, IOException {
        Push push = new ObjectMapper().readValue(body.get("push"),Push.class);
        String name = body.get("name");
        return pushService.addPushToUserName(push.getSendtime(), name, push.getMessage(), push.getTitle());
    }

    @PostMapping("/AddList")
    void addPush(@RequestParam String name) {
        listsService.create(new Lists(name));
    }

    @GetMapping("/all")
    List<Push> addPush() {
//        SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(role-> System.out.println(role.getAuthority()));
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().toString());
        return pushService.getAllPushes();
    }
}
