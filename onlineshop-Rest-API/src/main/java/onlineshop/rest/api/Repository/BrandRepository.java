package onlineshop.rest.api.Repository;

import onlineshop.rest.api.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findByBrandCode(String brandCode);
//    Brand findByBrandId(Long id);
//    List<Brand> findBrandByBrandCode(String brandCode);
//    List<Brand> getAllBrands();
}