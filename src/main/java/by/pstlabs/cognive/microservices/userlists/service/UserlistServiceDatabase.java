package by.pstlabs.cognive.microservices.userlists.service;

import by.pstlabs.cognive.microservices.userlists.model.Userlist;
import org.springframework.stereotype.Service;

/**
 * {@link by.pstlabs.cognive.microservices.userlists.service.UserlistService} implementation that stores data in memory
 * TODO implement methods
 *
 * @author Yury.Korzun
 */

@Service
public class UserlistServiceDatabase implements UserlistService {

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
