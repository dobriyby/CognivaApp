package by.pstlabs.cognive.microservices.userlists.service;

import by.pstlabs.cognive.microservices.userlists.model.UserList;

/**
 * @author Stepan Novikov
 */
public interface ListService {

    UserList createUserList(String name) throws Exception;

    UserList createUserList() throws Exception;

    UserList getUserList(int personId) throws Exception;

    Iterable<UserList> getUserLists() throws Exception;
}
