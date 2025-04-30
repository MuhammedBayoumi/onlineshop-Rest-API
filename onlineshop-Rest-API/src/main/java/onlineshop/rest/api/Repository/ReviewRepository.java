package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}