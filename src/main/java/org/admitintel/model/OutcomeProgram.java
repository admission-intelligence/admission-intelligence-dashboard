package org.admitintel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class OutcomeProgram extends PanacheEntity {

    public Double estimatedOutcomeCost;

}
