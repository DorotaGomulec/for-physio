package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String test(){
        return "ok";
    }

    @GetMapping ("/all")
    public List<Patient> getAllPatients(){
        return patientRepository.getAll();
    }

    @GetMapping ("/{id}")
    public Patient getByID(@PathVariable int id) {
        return patientRepository.getByID( id );
    }

    @GetMapping ("/contact")
    public List<PatientContactDTO> getContacts() {
       return patientRepository.getContacts();
    }

    @PostMapping("")
    public int addPatient(@RequestBody Patient patient){
        return patientRepository.addPatient(patient);
    }

    @DeleteMapping ("/{id}")
    public int deleteByID (@PathVariable int id){
        return patientRepository.deleteByID(id);
    }
}
