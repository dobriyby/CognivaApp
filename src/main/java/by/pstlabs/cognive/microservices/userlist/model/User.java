package by.pstlabs.cognive.microservices.userlist.model;

import by.pstlabs.cognive.microservices.notifications.model.Push;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lists_id")
    @JsonIgnore
    private Lists lists;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<Push> users;

    @Column
    private String email;


    public User() {
    }

    public User(String name, Lists lists) {
        this.name = name;
        this.lists = lists;
    }

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

    public Lists getLists() {
        return lists;
    }

    public void setLists(Lists userlist) {
        this.lists = userlist;
    }

    public Set<Push> getUsers() {
        return users;
    }

    public void setUsers(Set<Push> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userlist=" + lists +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
