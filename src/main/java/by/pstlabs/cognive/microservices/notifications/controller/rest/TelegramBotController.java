package by.pstlabs.cognive.microservices.notifications.controller.rest;

import by.pstlabs.cognive.microservices.notifications.service.TelegramBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class TelegramBotController {

    @Autowired
    TelegramBotService telegramBotService;

    @GetMapping("/bot/send")
    public void sendMessageTo(@RequestParam String message){
        telegramBotService.sendMessageToBigBoss(message);
    }

}
