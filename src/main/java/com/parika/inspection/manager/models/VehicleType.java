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
@Table(name = "vehicle_type")
public class VehicleType extends BaseEntity{
    @Column(name = "vehicle_Type_Desc_Eng")
    private String vehicleTypeDescEng;
    @Column(name = "vehicle_Type_Desc_Fr")
    private  String vehicleTypeDescFr;
    @Column(name = "vehicle_Type_Desc_Rw")
    private String vehicleTypeDescRw;
}
