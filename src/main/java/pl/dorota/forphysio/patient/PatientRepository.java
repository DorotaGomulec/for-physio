package pl.dorota.forphysio.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dorota.forphysio.patient.NewPatientDTO;
import pl.dorota.forphysio.patient.Patient;
import pl.dorota.forphysio.patient.PatientContactDTO;
import pl.dorota.forphysio.patient.PatientDTO;

import java.util.List;

@Repository
public class PatientRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addPatient(NewPatientDTO patient) {
        int injuryTypeID = patient.getInjuryType().ordinal() + 1;
        return jdbcTemplate.update( "insert into patient (name, age, gender, phone_number, has_insurance, injury_type_id) " +
                        "values (?, ?, ?, ?, ?, ?)",
                patient.getName(), patient.getAge(), patient.getGender().name(), patient.getPhoneNumber(),
                patient.getHasInsurance(), injuryTypeID );

    }

    public List<PatientDTO> getAll() {
        return jdbcTemplate.query( "select * from all_info_all_patients",
                BeanPropertyRowMapper.newInstance( PatientDTO.class ) );
    }

    public PatientDTO getAllInfoByID(int id) {
        return jdbcTemplate.queryForObject( "select * from all_info_all_patients where id = ?",
                BeanPropertyRowMapper.newInstance( PatientDTO.class ), id );
    }

    public Patient getByID(int id) {
        return jdbcTemplate.queryForObject( "select * from all_info_all_patients where id = ?",
                BeanPropertyRowMapper.newInstance( Patient.class ), id );
    }


    public int deleteByID(int id) {
        return jdbcTemplate.update( "delete from patient where id = ?", id );
    }

    public List<PatientContactDTO> getContacts() {
        List<Patient> patientList = jdbcTemplate.query( "select * from contacts_to_patients",
                BeanPropertyRowMapper.newInstance( Patient.class ) );

        List<PatientContactDTO> contactList = patientList.stream()
                .map( patient -> new PatientContactDTO( patient.getId(), patient.getName(), patient.getPhoneNumber() ) ).toList();

        return contactList;
    }

    public int update(Patient updatedPatient) {
        int injutyTypeId = updatedPatient.getInjuryType().ordinal() + 1;
        return jdbcTemplate.update( "UPDATE patient SET name=?, age=?, gender=?, phone_number=?, has_insurance=?, injury_type_id=? WHERE id = ?",
                updatedPatient.getName(), updatedPatient.getAge(), updatedPatient.getGender().name(),
                updatedPatient.getPhoneNumber(), updatedPatient.getHasInsurance(), injutyTypeId, updatedPatient.getId());
    }
}
