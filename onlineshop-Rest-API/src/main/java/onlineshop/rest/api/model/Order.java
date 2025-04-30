package onlineshop.rest.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_id_gen")
    @SequenceGenerator(name = "ORDERS_id_gen", sequenceName = "ORDERS_INFO_SEQ", allocationSize = 1)
    @Column(name = "ORDER_ID", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserInfo user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "QTY", nullable = false)
    private Long qty;

    @Size(max = 255)
    @NotNull
    @Column(name = "TRX_ID", nullable = false)
    private String trxId;

    @Size(max = 20)
    @NotNull
    @Column(name = "P_STATUS", nullable = false, length = 20)
    private String pStatus;

}