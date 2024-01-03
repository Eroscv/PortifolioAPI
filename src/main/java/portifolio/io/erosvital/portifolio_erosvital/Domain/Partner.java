package portifolio.io.erosvital.portifolio_erosvital.Domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Integer id;

    @GeneratedValue(strategy = GenerationType.UUID,generator = "uuidGenerator")
    @SequenceGenerator(name = "uuidGenerator")
    private long uuid;

    @Column(nullable = false, length = 200)
    private String name;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 11)
    private String rg;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 25)
    private String phone;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(name = "register_date")
    private LocalDate registerDate;

    private boolean active;
    
    public void updateFrom(Partner other) {
        this.setName(other.getName());
        this.setCpf(other.getCpf());
        this.setRg(other.getRg());
        this.setEmail(other.getEmail());
        this.setPhone(other.getPhone());
        this.setBirthDate(other.getBirthDate());
    }
    
}