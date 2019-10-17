package by.pstlabs.cognive.microservices.userlists.exception;


/**
 * @author Stepan Novikov
 */
public class UserlistNotFoundexception extends RuntimeException {

    private final int userlistId;

    public UserlistNotFoundexception(int userlistId) {
        this.userlistId = userlistId;
    }

    @Override
    public String getMessage() {
        return "Userlist with id = " + userlistId + " not found";
    }
}
