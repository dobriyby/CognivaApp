package by.pstlabs.cognive.microservices.userlists.service;

import by.pstlabs.cognive.microservices.userlists.model.Userlist;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

/**
 * {@link by.pstlabs.cognive.microservices.userlists.service.UserlistService} implementation that stores data in memory
 * TODO implement methods
 *
 * @author Yury.Korzun
 */

@Service
public class UserlistServiceDatabase implements UserlistService {
	
    private static Map<Integer, Userlist> userLists = new HashMap<>();

    @Autowired
    private PagingAndSortingRepository<Userlist, Integer> repo;

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
    
    @Override
	public String createUser(String name) throws Exception{
    	repo.save(new Userlist(name));
    		return repo.findAll().toString();
    }

	@Override
	public String getUserById(int id) throws Exception {
		Gson gs = new Gson();
		return gs.toJson(repo.findById(id));
	}
}
    
