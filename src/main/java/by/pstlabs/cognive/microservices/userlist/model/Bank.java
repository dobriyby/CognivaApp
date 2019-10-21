package by.pstlabs.cognive.microservices.userlist.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author Yuri.Korzun
 */

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotNull
    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private Map<Long, Lists> listsMap = new HashMap<>();

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

    public Map<Long, Lists> getListsMap() {
        return listsMap;
    }

    public void setListsMap(Map<Long, Lists> listsMap) {
        this.listsMap = listsMap;
    }

    public Collection<Lists> getLists(){
        return listsMap.values();
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
