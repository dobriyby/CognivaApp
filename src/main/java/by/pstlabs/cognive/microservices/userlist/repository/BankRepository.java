package by.pstlabs.cognive.microservices.userlist.repository;

import by.pstlabs.cognive.microservices.userlist.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
