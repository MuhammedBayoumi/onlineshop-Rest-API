package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.OrdersInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoRepository extends JpaRepository<OrdersInfo, Long> {

}
