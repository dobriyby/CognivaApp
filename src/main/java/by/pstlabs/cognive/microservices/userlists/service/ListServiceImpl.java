package by.pstlabs.cognive.microservices.userlists.service;

import by.pstlabs.cognive.microservices.userlists.exception.UserlistNotFoundexception;
import by.pstlabs.cognive.microservices.userlists.model.UserList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Stepan Novikov
 * @author Yury.Korzun
 */

@Service
public class ListServiceImpl implements ListService {

    private static final AtomicInteger counter = new AtomicInteger();
    private static Map<Integer, UserList> userLists = new HashMap<>();        // sync?

    @Override
    public UserList createUserList(String name) throws Exception {
        UserList userList = new UserList(counter.incrementAndGet(), name);
        userLists.put(userList.getId(), userList);
        return userList;
    }

    @Override
    public UserList createUserList() throws Exception {
        int id = counter.incrementAndGet();
        UserList userList = new UserList(id, "list №" + id);
        userLists.put(userList.getId(), userList);
        return userList;
    }

    @Override
    public UserList getUserList(int listId) {
        if(userLists.containsKey(listId)){
            return userLists.get(listId);
        } else {
            throw new UserlistNotFoundexception(listId);
        }
    }

    @Override
    public Iterable<UserList> getUserLists() throws Exception {
        return userLists.values();
    }

}