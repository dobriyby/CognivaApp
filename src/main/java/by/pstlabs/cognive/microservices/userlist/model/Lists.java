package by.pstlabs.cognive.microservices.userlist.model;

import by.pstlabs.cognive.common.model.User;

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

    //@OneToMany(mappedBy = "lists", cascade = CascadeType.ALL)
    @OneToMany
    @JoinTable(
            name="list_user",
            joinColumns = @JoinColumn(name="list_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public void addUser(User user){
        this.userSet.add(user);
    }

    public void deleteUser(User user){
        this.userSet.remove(user);
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
