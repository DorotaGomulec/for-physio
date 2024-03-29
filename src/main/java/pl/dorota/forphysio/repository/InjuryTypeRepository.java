package pl.dorota.forphysio.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dorota.forphysio.dto.InjuryTypeDTO;
import pl.dorota.forphysio.InjuryTypeEnum;

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
        List<InjuryTypeEnum> injuryTypeList =  Arrays.stream( InjuryTypeEnum.values() ).toList();
        List<InjuryTypeDTO> injuryTypeDTOList = injuryTypeList
                .stream()
                .map( injuryType -> new InjuryTypeDTO( injuryType.ordinal()+1, injuryType) ).toList();
    return injuryTypeDTOList;
    }

}
