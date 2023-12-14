package pl.dorota.forphysio;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class Visit {
    int visitId;
    String name;
    String date;



}
