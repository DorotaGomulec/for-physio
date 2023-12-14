package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    @GetMapping ("")
    public List<Visit> getVisits(){
        return visitRepository.getVisits();
    }

    @GetMapping ("/{patientId}")
    public List<Visit> getPatientsVisits(@PathVariable int patientId) {
        return visitRepository.getPatientsVisit(patientId);
    }

    @DeleteMapping ("/{visitId}")
    public int deleteByVisitID(@PathVariable int visitId) {
        return visitRepository.deleteByVisitID(visitId);
    }
}
