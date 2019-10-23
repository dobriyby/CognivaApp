package by.pstlabs.cognive.microservices.userlist.model;

import by.pstlabs.cognive.common.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @author Yuri.Korzun
 */

@Entity
@Table(name = "bank")
public class Bank extends BaseEntity {

    public Bank(){}

    public Bank(String name){
        this.name = name;
    }

    // @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    @OneToMany
    @JoinTable(
            name="bank_lists",
            joinColumns = @JoinColumn(name="bank_id"),
            inverseJoinColumns = @JoinColumn(name="lists_id")
    )
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

    public void addLists(Lists lists){
        listsMap.put(lists.getId(), lists);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
