package by.pstlabs.cognive.microservices.notifications.service;

import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.notifications.model.ApiResponse;
import by.pstlabs.cognive.microservices.notifications.model.MailNotificationRequest;
import by.pstlabs.cognive.microservices.notifications.model.Push;
import by.pstlabs.cognive.microservices.notifications.repository.PushRepository;
import by.pstlabs.cognive.microservices.userlist.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PushServiceImp implements PushService {

    @Autowired
    MailerSender mailer;

    @Autowired
    PushRepository pushRepo;

    @Autowired
    UserRepository userRepo;

    @Override
    public void checkSendTimePush() {
        List<Push> pushes = pushRepo.findPushesBySendtimeBeforeAndSendStatusFalse(new Date());
        for (Push push: pushes) {
            for (User user: push.getUsers()) {
                mailer.SendMail(new MailNotificationRequest(user.getEmail(),"Cogniva Push Notification",user.getName(),push.getMessage()));
            }
            push.setSendStatus(true);
            pushRepo.save(push);
        }
    }

    @Override
    public ResponseEntity<Object> addPushToAll(Date date, String text) {
        Push push = new Push();
        push.setSendtime(date);
        push.setUsers(userRepo.findAll());
        push.setSendStatus(false);
        push.setMessage(text);
        pushRepo.save(push);
        ApiResponse apiResponse =
                new ApiResponse(HttpStatus.OK, "Push success added to database!", 0, "");
        return new ResponseEntity<>(
                apiResponse, new HttpHeaders(), apiResponse.getStatus());
    }

    @Override
    public ResponseEntity<Object> addPushToUserName(Date date, String name, String text) {
        Push push = new Push();
        push.setSendStatus(false);
        push.setMessage(text);
        push.setSendtime(date);
        push.setUsers(userRepo.findAllByName(name));
        pushRepo.save(push);
        ApiResponse apiResponse =
                new ApiResponse(HttpStatus.OK, "Push success added to database!", 0, "");
        return new ResponseEntity<>(
                apiResponse, new HttpHeaders(), apiResponse.getStatus());
    }

    @Override
    public List<Push> getAllPushes() {
        return Lists.newArrayList(pushRepo.findAll());
    }

}

