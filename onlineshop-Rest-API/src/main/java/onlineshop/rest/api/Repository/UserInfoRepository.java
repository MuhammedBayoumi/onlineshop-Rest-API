package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}