package pl.dorota.forphysio.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
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

    @PostMapping("/{id}")
    public int addVisit(@PathVariable int id) {
        return visitRepository.addVisit( id );
    }


    @GetMapping("")
    public CollectionModel<EntityModel<Visit>> getVisits() {
        List<Visit> visitList = visitRepository.getVisits();
        List<EntityModel<Visit>> entityVisitList = visitList
                .stream()
                .map( visit -> EntityModel.of( visit ) )
                .toList();

        for (EntityModel<Visit> visitEntityModel : entityVisitList) {
            int visitId = visitEntityModel.getContent().getVisitId();
            visitEntityModel.add( WebMvcLinkBuilder.linkTo( VisitController.class ).slash( visitId ).withRel( "delete_visit" ) );
        }

        return CollectionModel.of( entityVisitList,
                WebMvcLinkBuilder.linkTo( VisitController.class ).withSelfRel() );
    }

    @GetMapping("/{patientId}")
    public CollectionModel<EntityModel<Visit>> getPatientsVisits(@PathVariable int patientId) {
        List<Visit> visitList = visitRepository.getPatientsVisit( patientId );
        List<EntityModel<Visit>> visitEntityList = visitList
                .stream()
                .map( visit -> EntityModel.of( visit ) ).toList();

        for (EntityModel<Visit> visitEntityModel : visitEntityList) {
            visitEntityModel.add( WebMvcLinkBuilder.linkTo( VisitController.class ).withSelfRel().withRel( "all_visits_all_patients" ));
        }

        Link link = (Link) WebMvcLinkBuilder.linkTo( VisitController.class ).slash( patientId ).withSelfRel();

        return CollectionModel.of( visitEntityList, link );
    }



        @DeleteMapping("/{visitId}")
        public int deleteByVisitID ( @PathVariable int visitId){
            return visitRepository.deleteByVisitID( visitId );
        }
    }

