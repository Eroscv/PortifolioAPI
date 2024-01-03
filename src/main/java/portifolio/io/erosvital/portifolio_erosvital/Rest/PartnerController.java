package portifolio.io.erosvital.portifolio_erosvital.Rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import portifolio.io.erosvital.portifolio_erosvital.Domain.Partner;
import portifolio.io.erosvital.portifolio_erosvital.Repository.PartnerRepository;



@RestController
@RequestMapping("/api/partners")
public class PartnerController {
    private final PartnerRepository repository;
    public PartnerController (PartnerRepository repository){
        this.repository = repository;
    }
    @GetMapping()
    public List<Partner> getAllPartners() {
        return repository.findAll();
    }
      @GetMapping("{id}")
    public Partner findById( @PathVariable Integer id ){
        return repository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parceiro não encontrado") );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        repository
            .findById(id)
            .map( partner -> {
                repository.delete(partner);
                return Void.TYPE;
            })
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parceiro não encontrado") );
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Partner save(@RequestBody Partner partner) {        
        return repository.save(partner);
    }   
    

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Validated Partner updatedPartner) {
    repository.findById(id)
            .map(partner -> {
                partner.updateFrom(updatedPartner);
                return repository.save(partner);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner not found"));
}


}
