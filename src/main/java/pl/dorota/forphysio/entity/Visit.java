package pl.dorota.forphysio.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dorota.forphysio.entity.Patient;

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
