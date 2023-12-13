package pl.dorota.forphysio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String phoneNumber;
    private InjuryType injuryType;
    private boolean hasInsurance;
    private int numberOfVisits;
    private String lastVisit;

    }

