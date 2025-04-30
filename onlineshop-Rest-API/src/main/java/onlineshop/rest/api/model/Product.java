package onlineshop.rest.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTS")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTS_id_gen")
    @SequenceGenerator(name = "PRODUCTS_id_gen", sequenceName = "ORDER_PRODUCTS_SEQ", allocationSize = 1)
    @Column(name = "PRODUCT_ID", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_CAT", nullable = false)
    private Category productCat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_BRAND", nullable = false)
    @NotFound(action = NotFoundAction.IGNORE)  // Add this annotation
    @JsonIgnore
    private Brand productBrand;

    @Size(max = 255)
    @NotNull
    @Column(name = "PRODUCT_TITLE", nullable = false)
    private String productTitle;

    @NotNull
    @Column(name = "PRODUCT_PRICE", nullable = false)
    private Long productPrice;

    @NotNull
    @Lob
    @Column(name = "PRODUCT_DESC", nullable = false)
    private String productDesc;

    @Size(max = 4000)
    @NotNull
    @Column(name = "PRODUCT_IMAGE", nullable = false, length = 4000)
    private String productImage;

    @Size(max = 4000)
    @NotNull
    @Column(name = "PRODUCT_KEYWORDS", nullable = false, length = 4000)
    private String productKeywords;

    @OneToMany(mappedBy = "p")
    private Set<Cart> carts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<OrderProduct> orderProducts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "p")
    private Set<Wishlist> wishlists = new LinkedHashSet<>();

}