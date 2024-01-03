package portifolio.io.erosvital.portifolio_erosvital.Rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import portifolio.io.erosvital.portifolio_erosvital.DTO.WorksDto;
import portifolio.io.erosvital.portifolio_erosvital.Domain.Partner;
import portifolio.io.erosvital.portifolio_erosvital.Domain.Works;
import portifolio.io.erosvital.portifolio_erosvital.Repository.PartnerRepository;
import portifolio.io.erosvital.portifolio_erosvital.Repository.WorksRepository;
import portifolio.io.erosvital.portifolio_erosvital.util.BigDecimalConverter;

@RestController
@RequestMapping("/api/works")
@RequiredArgsConstructor
public class WorksController  {
    
    private final PartnerRepository partnerRepository;
    private final WorksRepository repository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Works salvar( @RequestBody @Validated WorksDto dto ){
        LocalDate data = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdPartner();

        Partner partner =
                partnerRepository
                        .findById(idCliente)
                        .orElseThrow(() ->
                                new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST, "Parceiro inexistente."));


        Works Works = new Works();
        Works.setDescription(dto.getDescription());
        Works.setDate( data );
        Works.setPartner(partner);
        Works.setValue( bigDecimalConverter.converter(dto.getPrice())  );

        return repository.save(Works);
    }

    @GetMapping
    public List<Works> search(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "month", required = false) Integer month
    ) {
        return repository.findBynamepartnerAndmonth("%" + name + "%", month);
    }
}