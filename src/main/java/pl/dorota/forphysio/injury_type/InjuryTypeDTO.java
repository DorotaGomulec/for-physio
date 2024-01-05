package pl.dorota.forphysio.injury_type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InjuryTypeDTO {
    int id;
    InjuryTypeEnum name;
}
