package by.pstlabs.cognive.microservices.userlists.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Stepan Novikov
 */
@Entity
@Table(name = "users")
public class Userlist  {

	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name ="name")
    private String name;
	
	public Userlist() {
        
    }

    public Userlist(int id) {
        this(id, "no name");
    }

    public Userlist(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Userlist(String name){
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
    
    public String toString() {
    	return getId()+" "+getName();
    }
}
