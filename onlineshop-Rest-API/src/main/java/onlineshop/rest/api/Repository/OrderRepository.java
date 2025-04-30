package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}