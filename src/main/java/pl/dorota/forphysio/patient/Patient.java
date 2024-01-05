package pl.dorota.forphysio.patient;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;
import pl.dorota.forphysio.injury_type.InjuryType;
import pl.dorota.forphysio.injury_type.InjuryTypeEnum;

@Data
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, length = 45)
    private String name;
    private Integer age;
    @Enumerated
    private Gender gender;
    @Column(length = 20)
    private String phoneNumber;
    private Boolean hasInsurance;
    @ManyToOne
    @JoinColumn (name = "injury_type_id",referencedColumnName = "id")
    private InjuryType injuryType;

}

