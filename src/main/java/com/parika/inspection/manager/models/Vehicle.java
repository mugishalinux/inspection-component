package com.parika.inspection.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "PA_VEHICLE_CT")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "Chassis_No")
    private String chassisNo;
    @JoinColumn(name = "Plate_NO")
    private String plateNo;
    @ManyToOne
    @JoinColumn(name = "Brand_id")
    private VehicleBrand VehicleBrand;
    @ManyToOne
    @JoinColumn(name = "_Model_id")
    private VehicleModel VehicleModel;
    @ManyToOne
    @JoinColumn(name = "Vehicle_type_id")
    private VehicleType VehicleType;
    @ManyToOne
    @JoinColumn(name = "Pa_Status_id")
    private Status Status;
    @Column(name = "Front_Photo_Url")
    private String frontPhotoUrl;
    @Column(name = "Side_Photo_Url")
    private String sidePhotoUrl;
    @Column(name = "status_id")
    private int statusId;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "update_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
