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
@Table(name = "PA_VEHICLE_MODEL_LT")
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Model_Desc")
    private String modelDesc;
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
