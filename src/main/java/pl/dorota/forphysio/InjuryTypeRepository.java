package pl.dorota.forphysio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class InjuryTypeRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public InjuryTypeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<InjuryTypeDTO> getAll() {
        List<InjuryType> injuryTypeList =  Arrays.stream( InjuryType.values() ).toList();
        List<InjuryTypeDTO> injuryTypeDTOList = injuryTypeList
                .stream()
                .map( injuryType -> new InjuryTypeDTO( injuryType.ordinal()+1, injuryType) ).toList();
    return injuryTypeDTOList;
    }

}
