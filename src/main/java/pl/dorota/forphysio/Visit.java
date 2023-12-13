package pl.dorota.forphysio;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class Visit {
    Patient patient;
    Date date= new Date();
}
