package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}