package pl.dorota.forphysio.injury_type;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dorota.forphysio.patient.Patient;

@Entity
@NoArgsConstructor
@Data
public class InjuryType {
    @Id
    private int id;
    @Column(name = "name")
    @Enumerated
    private InjuryTypeEnum injuryTypeEnum;
}
