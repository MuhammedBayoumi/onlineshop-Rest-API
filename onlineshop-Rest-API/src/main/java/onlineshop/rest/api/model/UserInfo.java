package onlineshop.rest.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "USER_INFO")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_INFO_id_gen")
    @SequenceGenerator(name = "USER_INFO_id_gen", sequenceName = "USER_INFO_SEQ", allocationSize = 1)
    @Column(name = "USER_ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    private String firstName;

    @Size(max = 100)
    @NotNull
    @Column(name = "LAST_NAME", nullable = false, length = 100)
    private String lastName;

    @Size(max = 300)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 300)
    private String email;

    @Size(max = 300)
    @NotNull
    @Column(name = "PASSWORD", nullable = false, length = 300)
    private String password;

    @Size(max = 10)
    @NotNull
    @Column(name = "MOBILE", nullable = false, length = 10)
    private String mobile;

    @Size(max = 300)
    @NotNull
    @Column(name = "ADDRESS1", nullable = false, length = 300)
    private String address1;

    @Size(max = 11)
    @NotNull
    @Column(name = "ADDRESS2", nullable = false, length = 11)
    private String address2;

    @OneToMany(mappedBy = "user")
    private Set<Cart> carts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<OrdersInfo> ordersInfos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Wishlist> wishlists = new LinkedHashSet<>();

}