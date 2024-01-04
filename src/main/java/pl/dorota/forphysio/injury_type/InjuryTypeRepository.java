package pl.dorota.forphysio.injury_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dorota.forphysio.injury_type.InjuryType;
import pl.dorota.forphysio.injury_type.InjuryTypeDTO;

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
