package onlineshop.rest.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import onlineshop.rest.api.exception.ResponseEntityErrorException;
import onlineshop.rest.api.payloads.response.ApiResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "BRANDS")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANDS_id_gen")
    @SequenceGenerator(name = "BRANDS_id_gen", sequenceName = "BRANDS_SEQ", allocationSize = 1)
    @Column(name = "BRAND_ID", nullable = false)
    private Long id;

    @Size(max = 4000)
    @NotNull
    @Column(name = "BRAND_TITLE", nullable = false, length = 4000)
    private String brandTitle;

    @Size(max = 4000)
    @NotNull
    @Column(name = "BRAND_CODE", nullable = false, length = 50)
    private String brandCode;
    @OneToMany(mappedBy = "productBrand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    // Basic getters and setters without Lombok
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandTitle() {
        return brandTitle;
    }

    public void setBrandTitle(String brandTitle) {
        this.brandTitle = brandTitle;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    // For the products collection, use a standard getter/setter
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products != null ? new ArrayList<>(products) : new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setProductBrand(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setProductBrand(null);
    }



}