package pl.dorota.forphysio.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class VisitDTO {
    int visitId;
    String name;
    String date;



}
