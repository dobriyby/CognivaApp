package by.pstlabs.cognive.common.model;

import by.pstlabs.cognive.microservices.notifications.model.Push;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

/**
 * @author Stepan Novikov
 */

@Entity
@Table(name = "userchik")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;

   // @JoinColumn(name = "role_id", nullable = false)


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="roles_users",
            joinColumns = @JoinColumn(name="userchik_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="id")
    )
   // @JsonIgnore
    private Set<Role> role;

    @Column
    @NotNull
    protected String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    @JsonIgnore
    private Set<Push> pushes;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private boolean active = true;


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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public boolean getActive(){
        return isActive();
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }
}
