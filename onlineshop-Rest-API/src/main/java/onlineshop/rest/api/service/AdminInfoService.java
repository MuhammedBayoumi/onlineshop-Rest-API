package onlineshop.rest.api.service;

import onlineshop.rest.api.model.AdminInfo;
import onlineshop.rest.api.payloads.response.ApiResponse;

import java.util.List;

public interface AdminInfoService {
    public AdminInfo getAdminInfoById(Long id);
    public List<AdminInfo> getAllAdminInfo();
    public AdminInfo saveAdminInfo(AdminInfo adminInfo);
    public AdminInfo updateAdminInfo(Long id,AdminInfo adminInfo);
     public ApiResponse deleteAdminInfoById(Long id);
    public List<AdminInfo> getAdminInfoByUsername(String email);
}
