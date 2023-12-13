package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<InjuryTypeDTO> getAllInjuryTypes() {
        return injuryTypeRepository.getAll();
    }
}
