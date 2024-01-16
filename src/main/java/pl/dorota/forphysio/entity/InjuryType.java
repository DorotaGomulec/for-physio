package pl.dorota.forphysio.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dorota.forphysio.InjuryTypeEnum;

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
