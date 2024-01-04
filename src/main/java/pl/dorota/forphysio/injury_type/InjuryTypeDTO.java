package pl.dorota.forphysio.injury_type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.dorota.forphysio.injury_type.InjuryType;

@Getter
@AllArgsConstructor
public class InjuryTypeDTO {
    int id;
    InjuryType name;
}
