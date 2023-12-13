package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visit")
public class VisitController {

    VisitRepository visitRepository;

    @Autowired
    public VisitController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @PostMapping ("/{id}")
    public int addVisit(@PathVariable int id) {
       return visitRepository.addVisit( id );
    }

}
