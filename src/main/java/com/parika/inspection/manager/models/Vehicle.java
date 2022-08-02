package com.parika.inspection.manager.models;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "vehicle")
public class Vehicle extends BaseEntity{
    @JoinColumn(name = "Chassis_No")
    private String chassisNo;
    @JoinColumn(name = "Plate_NO")
    private String plateNo;
    @ManyToOne
    @JoinColumn(name = "Brand_id")
    private VehicleBrand vehicleBrand;
    @ManyToOne
    @JoinColumn(name = "Model_id")
    private VehicleModel vehicleModel;
    @ManyToOne
    @JoinColumn(name = "Vehicle_type_id")
    private VehicleType vehicleType;
    @Column(name = "Front_Photo_Url")
    private String frontPhotoUrl;
    @Column(name = "Side_Photo_Url")
    private String sidePhotoUrl;
}
