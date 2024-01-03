package portifolio.io.erosvital.portifolio_erosvital.DTO;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class WorksDto {
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String description;

    @NotEmpty(message = "{campo.preco.obrigatorio}")
    private String price;

    @NotEmpty(message = "{campo.data.obrigatorio}")
    private String date;

    @NotEmpty(message = "{campo.cliente.obrigatorio}")
    private Integer idPartner;
}

