package onlineshop.rest.api.service;

import onlineshop.rest.api.model.Brand;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {
//    public List<Brand> getAllBrands();

    public Brand getBrandById(int id);

    public Brand createBrand(Brand brand);

    public Brand updateBrand(Brand brand);

    public void deleteBrand(int id);

    public Brand getBrandByBrandName(String brandName);

    public Page<Brand> getBrandsByPage(int page, int size);

    Page<Brand> getBrandsByPage(int page, int size, String brandName);

}