package by.pstlabs.cognive.common.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;

    @Column
//    @NotNull
    protected String name;

    public BaseEntity(){}

    public BaseEntity(String name){
        this.name = name;
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

    public BaseEntity updateWith(BaseEntity entityUpdated){
        this.name = entityUpdated.name;
        return this;
    }

}
