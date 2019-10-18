package by.pstlabs.cognive.microservices.userlists.service;

import by.pstlabs.cognive.microservices.userlists.model.Userlist;
import org.springframework.stereotype.Service;

/**
 * {@link by.pstlabs.cognive.microservices.userlists.service.UserlistService} implementation that calls remote methods
 * TODO implement
 *
 * Stepan, I mean that we can give this interface to customer, for example,
 * {@link by.pstlabs.cognive.microservices.notifications}, to manage out entities (in case they have rights)
 *
 * @author Yury.Korzun
 */

@Service
public class UserlistServiceRemote implements UserlistService{
    @Override
    public Userlist createUserlist(String name) throws Exception {
        return null;
    }

    @Override
    public Userlist createUserlist() throws Exception {
        return null;
    }

    @Override
    public Userlist getUserlist(int personId) throws Exception {
        return null;
    }

    @Override
    public Iterable<Userlist> getUserlists() throws Exception {
        return null;
    }
}
