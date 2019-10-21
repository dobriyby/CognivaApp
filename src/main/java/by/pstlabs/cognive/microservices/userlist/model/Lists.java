package by.pstlabs.cognive.microservices.userlist.model;

import by.pstlabs.cognive.microservices.notifications.model.Push;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Stepan Novikov
 */

@Entity
@Table(name = "userlist")
public class Lists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "title",unique = true)
    private String title;

    @OneToMany(mappedBy = "lists", cascade = CascadeType.ALL)
    private Set<User> userSet = new HashSet<>();


    public Lists() {
    }

    public Lists(String title) {
        this.title = title;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public List<User> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(List<User> userList) {
//         this.userList = userList;
//    }

    @Override
    public String toString() {
        return "UserList{" +
                "id=" + id +
                ", typeOfList=" + title +
                '}';
    }



}
