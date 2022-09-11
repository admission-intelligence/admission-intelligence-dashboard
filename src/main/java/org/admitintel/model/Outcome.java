package org.admitintel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.util.UUID;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Outcome extends PanacheEntity {


    private String alertName;
    private String alertType;
    private String recommendedAction;
    private String triggers;
    private String severity;
    private String category;
    private String patientId = UUID.randomUUID().toString().substring(0,10);

}
