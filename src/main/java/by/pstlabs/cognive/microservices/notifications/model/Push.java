package by.pstlabs.cognive.microservices.notifications.model;

import by.pstlabs.cognive.common.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "push")
public class Push {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sendtime")
    private Date sendtime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="push_users",
            joinColumns = @JoinColumn(name="push_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="userchik_id", referencedColumnName="id")
    )
    private List<User> users;

    @Column(name = "sendStatus")
    private boolean sendStatus;

    @Column(name = "message")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(boolean sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
