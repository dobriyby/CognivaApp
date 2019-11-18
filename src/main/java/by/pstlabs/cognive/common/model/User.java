package by.pstlabs.cognive.common.model;

import by.pstlabs.cognive.microservices.notifications.model.Push;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author Stepan Novikov
 */

@Entity
@Table(name = "userchik")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;

    @Column
    @NotNull
    protected String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<Push> pushes;

    @Column
    private String email;


    public User() {
    }

    public User(String name){
        this.name = name;
    }

//    public User(String name, Lists lists) {
//        this.name = name;
//        this.lists = lists;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Push> getPushes() {
        return pushes;
    }

    public void setPushes(Set<Push> pushes) {
        this.pushes = pushes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", userlist=" + lists +
                '}';
    }


}
