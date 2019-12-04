package by.pstlabs.cognive.microservices.notifications.repository;

import by.pstlabs.cognive.microservices.notifications.model.Push;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PushRepository extends CrudRepository<Push, Long> {
    List<Push> findPushesBySendtimeBeforeAndSendStatusFalse(Date date);
}
