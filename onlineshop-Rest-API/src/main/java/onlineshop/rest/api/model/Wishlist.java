package onlineshop.rest.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "WISHLIST")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WISHLIST_id_gen")
    @SequenceGenerator(name = "WISHLIST_id_gen", sequenceName = "WISHLIST_SEQ", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "P_ID", nullable = false)
    private Product p;

    @Size(max = 250)
    @NotNull
    @Column(name = "IP_ADD", nullable = false, length = 250)
    private String ipAdd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserInfo user;

}