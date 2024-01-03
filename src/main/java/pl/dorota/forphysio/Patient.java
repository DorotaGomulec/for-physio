package pl.dorota.forphysio;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patient {
    private int id;
    @NotBlank (message = "Field name can not be blank")
    private String name;
    @Min( value = 0 , message = "Minimum value of age has to be 0" )
    @NumberFormat
    private Integer age;
    private Gender gender;
    private String phoneNumber;
    private InjuryType injuryType;
    private Boolean hasInsurance;
    private int numberOfVisits;
    private String lastVisit;

    public Patient(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

