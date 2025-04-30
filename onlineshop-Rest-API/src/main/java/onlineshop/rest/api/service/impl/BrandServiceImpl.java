package onlineshop.rest.api.service.impl;

import onlineshop.rest.api.Repository.BrandRepository;
import onlineshop.rest.api.exception.BlogapiException;
import onlineshop.rest.api.model.Brand;
import onlineshop.rest.api.model.Product;
import onlineshop.rest.api.payloads.response.ApiResponse;
import onlineshop.rest.api.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
class BrandServiceImpl implements BrandService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    BrandRepository brandRepository;
    private static final String YOU_DON_T_HAVE_PERMISSION_TO_MAKE_THIS_OPERATION = "You don't have permission to make this operation";
    private static final String NO_DATA_FOUND_TO_UPDATE = "NO DATA FOUND TO UPDATE";
    private static final String BRAND_ALREADY_EXISTS = "Brand with this code already exists";
//    @Override
//    public List<Brand> getAllBrands() {
//        return brandRepository.getAllBrands();
//    }

    @Override
    public Brand getBrandById(int id) {
        return null;
    }


    @Override
    @Transactional
    public Brand createBrand(Brand brandRequest) {
        Brand existingBrand = brandRepository.findByBrandCode(brandRequest.getBrandCode());
        if (existingBrand == null) {
            // Step 1: Create and save the brand first (without products)
            Brand newBrand = new Brand();
            newBrand.setBrandTitle(brandRequest.getBrandTitle());
            newBrand.setBrandCode(brandRequest.getBrandCode());
            List<Product> productsToAdd = new ArrayList<>();
            if (brandRequest.getProducts() != null) {
                productsToAdd.addAll(brandRequest.getProducts());
            }
            if (!productsToAdd.isEmpty()) {
                for (Product product : productsToAdd) {
                    // Add to the persisted product's collection
                    newBrand.getProducts().add(product);
                }
                brandRepository.saveAndFlush(newBrand);
                entityManager.detach(newBrand);
                return brandRequest;
            }
            return newBrand;
        } else {
            // Brand already exists
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage(BRAND_ALREADY_EXISTS);
            apiResponse.setSuccess(Boolean.FALSE);
            apiResponse.setStatus(HttpStatus.CONFLICT);
            throw new BlogapiException(HttpStatus.CONFLICT, apiResponse.toString());
        }
    }

    @Override
    public Brand updateBrand(Brand brand) {
        return null;
    }

    @Override
    public void deleteBrand(int id) {

    }

    @Override
    public Brand getBrandByBrandName(String brandName) {
        return null;
    }

    @Override
    public Page<Brand> getBrandsByPage(int page, int size) {
        return null;
    }

    @Override
    public Page<Brand> getBrandsByPage(int page, int size, String brandName) {
        return null;
    }


}
