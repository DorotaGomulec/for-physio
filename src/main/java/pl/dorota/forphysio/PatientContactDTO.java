package pl.dorota.forphysio;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PatientContactDTO {

    private int id;
    private String name;
    private String phoneNumber;

}
