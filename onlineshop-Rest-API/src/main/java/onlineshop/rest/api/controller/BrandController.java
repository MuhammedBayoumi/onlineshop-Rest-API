package onlineshop.rest.api.controller;

import onlineshop.rest.api.Repository.BrandRepository;
import onlineshop.rest.api.exception.ResponseEntityErrorException;
import onlineshop.rest.api.model.AdminInfo;
import onlineshop.rest.api.model.Brand;
import onlineshop.rest.api.payloads.response.ApiResponse;
import onlineshop.rest.api.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("onlineshop/api/Brand")
class BrandController {
    @Autowired
    BrandService brandService;
    @ExceptionHandler(ResponseEntityErrorException.class)
    public ResponseEntity<ApiResponse> handleExceptions(ResponseEntityErrorException exception) {
        return exception.getApiResponse();
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> createBrand(@Valid @RequestBody Brand brand) {
        Brand brandSaved = brandService.createBrand(brand);
        return new ResponseEntity< >(brandSaved, HttpStatus.CREATED);
    }

}
