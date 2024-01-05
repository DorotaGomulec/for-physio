package pl.dorota.forphysio.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.dorota.forphysio.visit.VisitController;

import java.util.List;

@RequestMapping("/patient")
@RestController
public class PatientController {

    PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/test")
    public String test() {
        return "ok";
    }

    @GetMapping("/all")
    public CollectionModel<EntityModel<PatientDTO>> getAllPatients() {
        List<PatientDTO> patientList = patientRepository.getAll();
        List<EntityModel<PatientDTO>> entityPatientList = patientList
                .stream()
                .map( patient -> EntityModel.of( patient ) )
                .toList();

        for (EntityModel<PatientDTO> patient : entityPatientList) {
            int patientId = patient.getContent().getId();
            patient.add( WebMvcLinkBuilder.linkTo( PatientController.class ).slash( patientId ).withSelfRel() );
        }

        return CollectionModel.of( entityPatientList,
                WebMvcLinkBuilder.linkTo( PatientController.class ).slash( "all" ).withSelfRel() );
    }

    @GetMapping("/{id}")
    public EntityModel<PatientDTO> getAllInfoByID(@PathVariable int id) {
        
        String hisHer = null;
        if (patientRepository.getById( id ).getGender() == Gender.MALE) hisHer = "his";
        if (patientRepository.getById( id ).getGender() == Gender.FEMALE) hisHer = "her";
        
        return EntityModel.of( patientRepository.getById( id ),
                WebMvcLinkBuilder.linkTo( PatientController.class ).slash( id ).withSelfRel(),
                WebMvcLinkBuilder.linkTo( PatientController.class ).slash( "/all" ).withRel( "all_patient" ),
                WebMvcLinkBuilder.linkTo( PatientController.class ).slash( id ).withRel( "delete" ),
                WebMvcLinkBuilder.linkTo( PatientController.class ).slash( id ).withRel( "update" ),
                WebMvcLinkBuilder.linkTo( VisitController.class ).slash( id ).withRel( hisHer + "_visits" ) );
    }

    @GetMapping("/contact")
    public CollectionModel<EntityModel<PatientContactDTO>> getContacts() {
        List<PatientContactDTO> patientContactList = patientRepository.getContacts();
        List<EntityModel<PatientContactDTO>> entityPatientContactList = patientContactList
                .stream()
                .map( patientContactDTO -> EntityModel.of( patientContactDTO ) )
                .toList();
        for (EntityModel<PatientContactDTO> patientContactEntityM : entityPatientContactList) {
            int patientId = patientContactEntityM.getContent().getId();
            patientContactEntityM.add( WebMvcLinkBuilder.linkTo( PatientController.class ).slash(patientId).withSelfRel() );
        }

        return CollectionModel.of( entityPatientContactList,
                WebMvcLinkBuilder.linkTo( PatientController.class ).slash( "contact" ).withSelfRel() );
    }

    @PostMapping("")
    public int addPatient( @Validated @RequestBody NewPatientDTO patient) {
        return patientRepository.addPatient( patient );
    }

    @DeleteMapping("/{id}")
    public int deleteByID(@PathVariable int id) {
        return patientRepository.deleteByID( id );
    }

    @PatchMapping("/{id}")
    public int updatePatient(@PathVariable int id, @RequestBody @Validated UpdatePatientDTO updatedPatient) {


        PatientDTO patientToUpdate = patientRepository.getById( id );
        if (updatedPatient.getName() != null) patientToUpdate.setName( updatedPatient.getName() );
        if (updatedPatient.getAge() != 0) patientToUpdate.setAge( updatedPatient.getAge() );
        if (updatedPatient.getGender() != null) patientToUpdate.setGender( updatedPatient.getGender() );
        if (updatedPatient.getInjuryType() != null) patientToUpdate.setInjuryType( updatedPatient.getInjuryType() );
        if (updatedPatient.getPhoneNumber() != null) patientToUpdate.setPhoneNumber( updatedPatient.getPhoneNumber() );
        if (updatedPatient.getHasInsurance() != null)
            patientToUpdate.setHasInsurance( updatedPatient.getHasInsurance() );

        return patientRepository.update( patientToUpdate);
    }
}
