package com.parika.inspection.manager.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "vehicle_model")
public class VehicleModel extends BaseEntity{
    @Column(name = "Model_Desc")
    private String modelDesc;
}
