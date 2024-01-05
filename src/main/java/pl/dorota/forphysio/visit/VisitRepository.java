package pl.dorota.forphysio.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<VisitDTO> getVisits() {
        return jdbcTemplate.query( "select * from  all_visits_all_patients", BeanPropertyRowMapper.newInstance( VisitDTO.class ) );
    }

    public List<VisitDTO>
    getPatientsVisit(int id) {
        return jdbcTemplate.query( "select * from  all_visits_all_patients where patient_id=?",
                BeanPropertyRowMapper.newInstance( VisitDTO.class ), id);
    }


    public int deleteByVisitID(int visitId) {
       return jdbcTemplate.update( "delete from visit where id=?",visitId );
    }
}
