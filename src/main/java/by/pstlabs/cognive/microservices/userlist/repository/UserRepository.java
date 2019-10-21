package by.pstlabs.cognive.microservices.userlist.repository;

import by.pstlabs.cognive.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Stepan Novikov
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findByListsId(Long listId);

//    Optional<User> findByIdAndListsId(Long id, Long listId);
}
