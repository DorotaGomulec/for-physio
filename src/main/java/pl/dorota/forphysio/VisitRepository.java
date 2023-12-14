package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class VisitRepository {

    JdbcTemplate jdbcTemplate;
    @Autowired
    public VisitRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addVisit(int patientID){
        return jdbcTemplate.update( "insert into visit (patient_id,date) values (?, curdate())",patientID );
    }

    public List<Visit> getVisits() {
        return jdbcTemplate.query( "select * from  all_visits_all_patients", BeanPropertyRowMapper.newInstance( Visit.class ) );
    }

    public List<Visit>
    getPatientsVisit(int id) {
        return jdbcTemplate.query( "select * from  all_visits_all_patients where patient_id=?",
                BeanPropertyRowMapper.newInstance( Visit.class ), id);
    }


    public int deleteByVisitID(int visitId) {
       return jdbcTemplate.update( "delete from visit where id=?",visitId );
    }
}
