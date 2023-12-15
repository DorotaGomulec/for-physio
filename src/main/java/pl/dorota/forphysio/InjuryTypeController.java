package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/injurytype")
public class InjuryTypeController {

    InjuryTypeRepository injuryTypeRepository;

    @Autowired
    public InjuryTypeController(InjuryTypeRepository injuryTypeRepository) {
        this.injuryTypeRepository = injuryTypeRepository;
    }

    @GetMapping ("")
    public CollectionModel<EntityModel<InjuryTypeDTO>> getAllInjuryTypes() {
        List<InjuryTypeDTO> injuryTypeDTOList = injuryTypeRepository.getAll();
        List<EntityModel<InjuryTypeDTO>> entityInjuryTypeDTOList = injuryTypeDTOList
                .stream()
                .map( injuryTypeDTO -> EntityModel.of( injuryTypeDTO ) ).toList();

        return CollectionModel.of( entityInjuryTypeDTOList,
                WebMvcLinkBuilder.linkTo( InjuryTypeController.class ).withSelfRel() );
    }
}
