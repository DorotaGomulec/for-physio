package pl.dorota.forphysio;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    private int id;
    private String name;
    private Integer age;
    private Gender gender;
    private String phoneNumber;
    private InjuryType injuryType;
    private Boolean hasInsurance;
    private int numberOfVisits;
    private String lastVisit;

}

