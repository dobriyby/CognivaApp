package by.pstlabs.cognive.microservices.userlists.service;

import by.pstlabs.cognive.microservices.userlists.model.Userlist;

/**
 * @author Stepan Novikov
 */
public interface UserlistService {

    Userlist createUserlist(String name) throws Exception;

    Userlist createUserlist() throws Exception;

    Userlist getUserlist(int personId) throws Exception;

    Iterable<Userlist> getUserlists() throws Exception;
    
    String createUser(String name) throws Exception;
    
    String getUserById(int id) throws Exception;
}
