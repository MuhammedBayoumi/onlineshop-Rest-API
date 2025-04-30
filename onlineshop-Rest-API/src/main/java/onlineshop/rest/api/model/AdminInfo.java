package onlineshop.rest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "ADMIN_INFO")
public class AdminInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_INFO_id_gen")
    @SequenceGenerator(name = "ADMIN_INFO_id_gen", sequenceName = "ADMIN_INFO_SEQ", allocationSize = 1)
    @Column(name = "ADMIN_ID", nullable = false)
    @JsonIgnore
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "ADMIN_NAME", nullable = false, length = 100)
    private String adminName;

    @Size(max = 300)
    @NotNull
    @Column(name = "ADMIN_EMAIL", nullable = false, length = 300)
    private String adminEmail;

    @Size(max = 300)
    @NotNull
    @Column(name = "ADMIN_PASSWORD", nullable = false, length = 300)
    private String adminPassword;

}