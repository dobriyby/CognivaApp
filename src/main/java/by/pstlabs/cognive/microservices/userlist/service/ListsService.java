package by.pstlabs.cognive.microservices.userlist.service;

import by.pstlabs.cognive.common.exception.ResourceNotFoundException;
import by.pstlabs.cognive.common.model.User;
import by.pstlabs.cognive.microservices.notifications.model.MailNotificationRequest;
import by.pstlabs.cognive.microservices.notifications.service.MailerSender;
import by.pstlabs.cognive.microservices.userlist.model.Lists;
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
    private UserService userService;

    @Autowired
    private MailerSender mailerSenderService;

    private final String notificationTemplate = "You`ve been %s list %s!";
    private void notificate(User user, Lists lists, String action){
        mailerSenderService.SendMail(new MailNotificationRequest(
                user.getEmail(),
                "Userlist update", user.getName(),
                String.format(notificationTemplate, action, lists.getName())));
    }

    public Lists updateLists(Long listsId, Lists listRequest) throws ResourceNotFoundException {
        return repository.findById(listsId).map(list -> {
            list.setName(listRequest.getName());
            return repository.save(list);
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }

    public HttpStatus deleteLists(Long listsId) throws ResourceNotFoundException {
        return repository.findById(listsId).map(list -> {
            repository.delete(list);
            return HttpStatus.OK;
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }

    public List<User> getAllUserByListsId(Long listsId) throws ResourceNotFoundException {
        return repository.findById(listsId).map(list -> {
            return new ArrayList<>(list.getUserSet());
        }).orElseThrow(() -> new ResourceNotFoundException("List not found with id " + listsId));
    }

    public User addUser(Long listsId, User user) throws ResourceNotFoundException {
        return repository.findById(listsId).map(list -> {

            for (User u : list.getUserSet()) {
                System.out.println(u);
            }

            System.out.println("User to add: " + user);

            // persist the lists
            list.addUser(userService.createUser(user));
            repository.save(list);

            // send push
            notificate(user, list, "added to");

            return user;

        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }

    public HttpStatus deleteUser(Long listsId, Long userId) throws ResourceNotFoundException {
        User user = userService.findById(userId);
        return repository.findById(listsId).map(list -> {

            // persist
            list.deleteUser(user);
            repository.save(list);

            // send push
            notificate(user, list, "deleted from");

            return HttpStatus.OK;

        }).orElseThrow(() -> new ResourceNotFoundException("List not found with id " + listsId));
    }

    public boolean isUserInList(Long listsId, User user) throws ResourceNotFoundException {
        return repository.findById(listsId).map((list) -> {
            return list.getUserSet().contains(user);
        }).orElseThrow(() -> new ResourceNotFoundException("ListsId " + listsId + " not found"));
    }
}
