package onlineshop.rest.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "EMAIL_INFO")
public class EmailInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAIL_INFO_id_gen")
    @SequenceGenerator(name = "EMAIL_INFO_id_gen", sequenceName = "EMAIL_INFO_SEQ", allocationSize = 1)
    @Column(name = "EMAIL_ID", nullable = false)
    private Long id;

    @Size(max = 4000)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 4000)
    private String email;

}