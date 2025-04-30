package onlineshop.rest.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "LOGS")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGS_id_gen")
    @SequenceGenerator(name = "LOGS_id_gen", sequenceName = "LOGS_SEQ", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "USER_ID", nullable = false, length = 50)
    private String userId;

    @Size(max = 50)
    @NotNull
    @Column(name = "ACTION", nullable = false, length = 50)
    private String action;

    @NotNull
    @Column(name = "LOG_DATE", nullable = false)
    private LocalDate logDate;

}