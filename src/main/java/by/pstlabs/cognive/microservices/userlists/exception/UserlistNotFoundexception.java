package by.pstlabs.cognive.microservices.userlists.exception;


/**
 * @author Stepan Novikov
 */
public class UserlistNotFoundexception extends RuntimeException {

    private final long userlistId;

    public UserlistNotFoundexception(long listId) {
        this.userlistId = listId;
    }

    @Override
    public String getMessage() {
        return "Userlist with id = " + userlistId + " not found";
    }
}
