package by.pstlabs.cognive.microservices.userlist.model;

import by.pstlabs.cognive.common.model.BaseEntity;
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
public class Lists extends BaseEntity {

    public Lists(){}

    public Lists(String name){
        this.name = name;
    }

    //@OneToMany(mappedBy = "lists", cascade = CascadeType.ALL)
    @OneToMany
    @JoinTable(
            name="list_user",
            joinColumns = @JoinColumn(name="list_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private Set<User> userSet = new HashSet<>();

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

    @Override
    public String toString() {
        return "UserList{" +
                "id=" + id +
                ", typeOfList=" + name +
                '}';
    }

}
