package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.AdminInfo;
import onlineshop.rest.api.payloads.response.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminInfoRepository extends JpaRepository<AdminInfo, Long> {
    AdminInfo getAdminInfoById(Long id);

    void deleteAdminInfoById(Long id);

    List<AdminInfo> findAdminInfosByAdminEmail(String adminEmail);
}