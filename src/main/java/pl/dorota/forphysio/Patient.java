package pl.dorota.forphysio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Patient {
    @Id
    private int id;
    @NotBlank
    private String name;
    @Min( value = 0)
    private Integer age;
    private Gender gender;
    @Size(min = 9, max = 15)
    private String phoneNumber;
    private InjuryType injuryType;
    private Boolean hasInsurance;
    private int numberOfVisits;
    private String lastVisit;

}

