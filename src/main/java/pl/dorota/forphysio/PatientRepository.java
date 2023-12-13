package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addPatient(Patient patient) {
        int injuryTypeID = patient.getInjuryType().ordinal() + 1;
        return jdbcTemplate.update( "insert into patient (name, age, gender, phone_number, has_insurance, injury_type_id) " +
                        "values (?, ?, ?, ?, ?, ?)",
                patient.getName(), patient.getAge(), patient.getGender().name(), patient.getPhoneNumber(),
                patient.isHasInsurance(), injuryTypeID );

    }

    public List<Patient> getAll() {
        return jdbcTemplate.query( "select * from all_info_all_patients",
                BeanPropertyRowMapper.newInstance( Patient.class ) );
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
                .map( patient -> new PatientContactDTO( patient.getName(), patient.getPhoneNumber() ) ).toList();

        return contactList;
    }
}
