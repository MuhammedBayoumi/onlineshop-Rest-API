package onlineshop.rest.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "ORDER_PRODUCTS")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_PRODUCTS_id_gen")
    @SequenceGenerator(name = "ORDER_PRODUCTS_id_gen", sequenceName = "ORDER_PRODUCTS_SEQ", allocationSize = 1)
    @Column(name = "ORDER_PRO_ID", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private OrdersInfo order;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @Column(name = "QTY")
    private Long qty;

    @Column(name = "AMT")
    private Long amt;

}