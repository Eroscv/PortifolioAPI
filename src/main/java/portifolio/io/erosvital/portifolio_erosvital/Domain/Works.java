package portifolio.io.erosvital.portifolio_erosvital.Domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Works {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Integer id;

    @GeneratedValue(strategy = GenerationType.UUID,generator = "uuidGenerator")
    @SequenceGenerator(name = "uuidGenerator")
    private long uuid;
    
    @Column(nullable = false, length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_partner")
    private Partner partner;
    
    @Column(nullable = false)
    private BigDecimal value;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}