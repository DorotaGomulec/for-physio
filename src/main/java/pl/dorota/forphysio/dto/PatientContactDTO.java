package pl.dorota.forphysio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PatientContactDTO {

    private int id;
    private String name;
    private String phoneNumber;

}
