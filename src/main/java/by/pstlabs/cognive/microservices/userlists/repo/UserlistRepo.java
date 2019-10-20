package by.pstlabs.cognive.microservices.userlists.repo;

import by.pstlabs.cognive.microservices.userlists.model.Userlist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserlistRepo extends PagingAndSortingRepository<Userlist, Integer> {
	
}
