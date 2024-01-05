package pl.dorota.forphysio.visit;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dorota.forphysio.patient.Patient;

@Entity
@NoArgsConstructor
@Data
public class Visit {
    @Id
    int id;
    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    Patient patientId;
    @Column(length = 15)
    String date;
}
