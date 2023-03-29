package db.entities.models.keys;

import db.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
public class TrainingKey implements Serializable {
    private Athlete athlete;
    private TrainerLicense trainerLicense;
}
