package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CollectionModel<EntityModel<Visit>> getVisits(){
        List<Visit> visitList = visitRepository.getVisits();
        List<EntityModel<Visit>> entityVisitList = visitList
                .stream()
                .map( visit -> EntityModel.of( visit ) )
                .toList();
        return CollectionModel.of( entityVisitList, WebMvcLinkBuilder.linkTo(VisitController.class).withSelfRel() );
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
