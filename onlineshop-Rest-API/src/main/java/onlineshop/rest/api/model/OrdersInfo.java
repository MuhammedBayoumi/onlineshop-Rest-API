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
@Table(name = "ORDERS_INFO")
public class OrdersInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_INFO_id_gen")
    @SequenceGenerator(name = "ORDERS_INFO_id_gen", sequenceName = "ORDERS_INFO_SEQ", allocationSize = 1)
    @Column(name = "ORDER_ID", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserInfo user;

    @Size(max = 255)
    @NotNull
    @Column(name = "F_NAME", nullable = false)
    private String fName;

    @Size(max = 255)
    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Size(max = 255)
    @NotNull
    @Column(name = "CITY", nullable = false)
    private String city;

    @Size(max = 255)
    @NotNull
    @Column(name = "STATE", nullable = false)
    private String state;

    @NotNull
    @Column(name = "ZIP", nullable = false)
    private Long zip;

    @Size(max = 255)
    @NotNull
    @Column(name = "CARDNAME", nullable = false)
    private String cardname;

    @Size(max = 20)
    @NotNull
    @Column(name = "CARDNUMBER", nullable = false, length = 20)
    private String cardnumber;

    @Size(max = 255)
    @NotNull
    @Column(name = "EXPDATE", nullable = false)
    private String expdate;

    @Column(name = "PROD_COUNT")
    private Long prodCount;

    @Column(name = "TOTAL_AMT")
    private Long totalAmt;

    @NotNull
    @Column(name = "CVV", nullable = false)
    private Integer cvv;

    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> orderProducts = new LinkedHashSet<>();

}