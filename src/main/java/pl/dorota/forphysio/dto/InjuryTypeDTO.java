package pl.dorota.forphysio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.dorota.forphysio.InjuryTypeEnum;

@Getter
@AllArgsConstructor
public class InjuryTypeDTO {
    int id;
    InjuryTypeEnum name;
}
