package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.EmailInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailInfoRepository extends JpaRepository<EmailInfo, Long> {
}