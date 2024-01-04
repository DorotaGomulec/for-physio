package pl.dorota.forphysio;

import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Valid
public class UpdatePatientDTO {

    @NotBlank(message = "Field name can not be blank")
    private String name;
    @Min( value = 0 , message = "Minimum value of age has to be 0" )
    private Integer age;
    private Gender gender;
    @Size(min = 9,max = 15, message = "Phone number has to have 9 to 15 characters")
    private String phoneNumber;
    private InjuryType injuryType;
    private Boolean hasInsurance;
}
