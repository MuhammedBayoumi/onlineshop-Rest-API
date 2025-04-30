package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository1 extends JpaRepository<OrderProduct, Long> {
}