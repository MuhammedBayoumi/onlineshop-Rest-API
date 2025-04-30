package onlineshop.rest.api.service.impl;

import onlineshop.rest.api.Repository.AdminInfoRepository;
import onlineshop.rest.api.exception.BlogapiException;
import onlineshop.rest.api.model.AdminInfo;
import onlineshop.rest.api.payloads.response.ApiResponse;
import onlineshop.rest.api.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoRepository adminInfoRepository;
    private static final String YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION = "You don't have permission to make this operation";
    private static final String NO_DATA_FOUND_TO_UPDATE = "NO DATA FOUND TO UPDATE";

    @Override
    public AdminInfo getAdminInfoById(Long id) {
        AdminInfo adminInfo = adminInfoRepository.getAdminInfoById(id);
        return adminInfo;
    }

    @Override
    public List<AdminInfo> getAllAdminInfo() {
        return adminInfoRepository.findAll();
    }

    @Override
    public AdminInfo saveAdminInfo(AdminInfo adminInfo) {
        return adminInfoRepository.save(adminInfo);
    }

    @Override
    public AdminInfo updateAdminInfo(Long id, AdminInfo adminInfo) {
        AdminInfo existingAdmin = adminInfoRepository.findById(id)
                .orElseThrow(() -> new BlogapiException(HttpStatus.UNAUTHORIZED, NO_DATA_FOUND_TO_UPDATE + " Admin not found with id: " + id));

        // Selectively update only the fields that are provided
        if (adminInfo.getAdminName() != null) {
            existingAdmin.setAdminName(adminInfo.getAdminName());
        }

        if (adminInfo.getAdminEmail() != null) {
            existingAdmin.setAdminEmail(adminInfo.getAdminEmail());
        }

        if (adminInfo.getAdminPassword() != null) {
            // Consider password hashing before storing
            existingAdmin.setAdminPassword(adminInfo.getAdminPassword());
        }
        // Save the updated entity and return it
        return adminInfoRepository.save(existingAdmin);
    }



    @Override
    public ApiResponse deleteAdminInfoById(Long id) {
        AdminInfo existingAdmin = adminInfoRepository.findById(id)
                .orElseThrow(() -> new BlogapiException(HttpStatus.NOT_FOUND, NO_DATA_FOUND_TO_UPDATE + " Admin not found with id: " + id));

        adminInfoRepository.deleteAdminInfoById(id);
        ApiResponse  apiResponse = new ApiResponse();
        apiResponse.setMessage("Successfully deleted admin info with id: " + id);
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setSuccess(Boolean.TRUE);
        return apiResponse;
    }

    @Override
    public List<AdminInfo> getAdminInfoByUsername(String email) {
        return adminInfoRepository.findAdminInfosByAdminEmail(email);
    }

}
