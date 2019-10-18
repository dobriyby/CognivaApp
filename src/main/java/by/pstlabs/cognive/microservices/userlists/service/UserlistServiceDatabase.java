package by.pstlabs.cognive.microservices.userlists.service;

import by.pstlabs.cognive.microservices.userlists.model.Userlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 * {@link by.pstlabs.cognive.microservices.userlists.service.UserlistService} implementation that stores data in memory
 * TODO implement methods
 *
 * @author Yury.Korzun
 */

@Service
public class UserlistServiceDatabase implements UserlistService {

//    @Autowired
//    private PagingAndSortingRepository<Userlist, Integer> repo;

    @Override
    public Userlist createUserlist(String name) throws Exception {
        return null;
    }

    @Override
    public Userlist createUserlist() throws Exception {
        return null;
    }

    @Override
    public Userlist getUserlist(int listId) throws Exception {
        return null;
    }

    @Override
    public Iterable<Userlist> getUserlists() throws Exception {
        return null;
    }
}
