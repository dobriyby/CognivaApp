package by.pstlabs.cognive.microservices.userlist.repository;

import by.pstlabs.cognive.microservices.userlist.model.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Stepan Novikov
 */

@Repository
public interface ListsRepository extends JpaRepository<Lists, Long> {

}
