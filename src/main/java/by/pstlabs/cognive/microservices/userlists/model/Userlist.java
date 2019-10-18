package by.pstlabs.cognive.microservices.userlists.model;

/**
 * @author Stepan Novikov
 */
public class Userlist {

    private int id;
    private String name;

    public Userlist(int id) {
        this(id, "no name");
    }

    public Userlist(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
