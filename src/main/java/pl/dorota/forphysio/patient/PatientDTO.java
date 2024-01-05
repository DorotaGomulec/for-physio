package pl.dorota.forphysio.patient;

import lombok.Data;
import pl.dorota.forphysio.injury_type.InjuryTypeEnum;

@Data
public class PatientDTO {

    private int id;
    private String name;
    private Integer age;
    private Gender gender;
    private String phoneNumber;
    private InjuryTypeEnum injuryType;
    private Boolean hasInsurance;
    private int numberOfVisits;
    private String lastVisit;
}
