package onlineshop.rest.api.controller;

import onlineshop.rest.api.model.AdminInfo;
import onlineshop.rest.api.payloads.response.ApiResponse;
import onlineshop.rest.api.service.impl.AdminInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("onlineshop/api/Admin")
class AdminInfoController {
    @Autowired
    private AdminInfoServiceImpl adminInfoService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminInfo addAdmin(@Valid @RequestBody AdminInfo adminInfo) {
        return adminInfoService.saveAdminInfo(adminInfo);
    }
    @GetMapping("/getAllAdminInfo")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
     public List<AdminInfo> getAllAdminInfo() {
        return adminInfoService.getAllAdminInfo();
    }

    @PutMapping("/{id}/updateAdminInfo")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  AdminInfo  updateAdminInfo(@PathVariable(name = "id") Long id,@Valid @RequestBody AdminInfo adminInfo) {
        return adminInfoService.updateAdminInfo(id,adminInfo);
    }

    @DeleteMapping("/{id}/deleteAdminInfo")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse deleteAdminInfo(@PathVariable(name = "id") Long id) {
        return adminInfoService.deleteAdminInfoById(id);
    }
}
