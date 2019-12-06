package by.pstlabs.cognive.microservices.userlist.service;

import by.pstlabs.cognive.common.model.BaseEntity;
import by.pstlabs.cognive.common.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService <T extends BaseEntity> {

    @Autowired
    protected JpaRepository<T, Long> repository;

    public List<T> findAll(){
        return repository.findAll();
    }

    public T findById(Long id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public T create(T entity){
        return repository.save(entity);
    }

}
