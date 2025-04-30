package onlineshop.rest.api.controller;

import onlineshop.rest.api.Repository.BrandRepository;
import onlineshop.rest.api.model.AdminInfo;
import onlineshop.rest.api.model.Brand;
import onlineshop.rest.api.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("onlineshop/api/Brand")
class BrandController {
     @Autowired
     BrandService brandService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand>  createBrand(@Valid @RequestBody Brand brand) {
        Brand brandSaved=brandService.createBrand(brand);
        return new ResponseEntity< >(brandSaved, HttpStatus.CREATED);
    }

}
