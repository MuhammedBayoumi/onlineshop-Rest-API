package onlineshop.rest.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "REVIEWS")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEWS_id_gen")
    @SequenceGenerator(name = "REVIEWS_id_gen", sequenceName = "REVIEWS_SEQ", allocationSize = 1)
    @Column(name = "REVIEW_ID", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @Size(max = 30)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @Size(max = 50)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "REVIEW", nullable = false)
    private String review;

    @NotNull
    @Column(name = "DATETIME", nullable = false)
    private Instant datetime;

    @NotNull
    @Column(name = "RATING", nullable = false)
    private Boolean rating = false;

}