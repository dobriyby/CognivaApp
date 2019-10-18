package by.pstlabs.cognive.microservices.userlists.service;

import by.pstlabs.cognive.microservices.userlists.exception.UserlistNotFoundexception;
import by.pstlabs.cognive.microservices.userlists.model.Userlist;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link by.pstlabs.cognive.microservices.userlists.service.UserlistService} implementation that stores data in memory
 *
 * @author Stepan Novikov
 * @author Yury.Korzun
 */

@Service
public class UserlistServiceInMemory implements UserlistService {

    private static final AtomicInteger counter = new AtomicInteger();
    private static Map<Integer, Userlist> userLists = new HashMap<>();        // sync?

    @Override
    public Userlist createUserlist(String name) throws Exception {
        Userlist userList = new Userlist(counter.incrementAndGet(), name);
        userLists.put(userList.getId(), userList);
        return userList;
    }

    @Override
    public Userlist createUserlist() throws Exception {
        int id = counter.incrementAndGet();
        Userlist userList = new Userlist(id, "list №" + id);
        userLists.put(userList.getId(), userList);
        return userList;
    }

    @Override
    public Userlist getUserlist(int listId) {
        if(userLists.containsKey(listId)){
            return userLists.get(listId);
        } else {
            throw new UserlistNotFoundexception(listId);
        }
    }

    @Override
    public Iterable<Userlist> getUserlists() throws Exception {
        return userLists.values();
    }

}