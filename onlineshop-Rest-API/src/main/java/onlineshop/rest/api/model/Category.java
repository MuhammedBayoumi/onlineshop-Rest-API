package onlineshop.rest.api.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIES_id_gen")
    @SequenceGenerator(name = "CATEGORIES_id_gen", sequenceName = "CATEGORIES_SEQ", allocationSize = 1)
    @Column(name = "CAT_ID", nullable = false)
    private Long id;

    @Size(max = 4000)
    @NotNull
    @Column(name = "CAT_TITLE", nullable = false, length = 4000)
    private String catTitle;

    @OneToMany(mappedBy = "productCat")
    private Set<Product> products = new LinkedHashSet<>();

    public Category(String catTitle, Set<Product> products) {
        this.catTitle = catTitle;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", catTitle='" + catTitle + '\'' +
                ", products=" + products +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}