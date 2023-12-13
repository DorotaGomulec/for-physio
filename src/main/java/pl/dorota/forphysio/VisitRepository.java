package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
