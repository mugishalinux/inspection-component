package com.parika.inspection.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "parking_inspections")
public class ParkingInspections extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "slot_id")
    private ParkingSlot slotId;
    @ManyToOne
    @JoinColumn(name = "field_agent_id")
    private FieldAgents fieldAgents;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @Column(name = "is_system_initiated")
    private char isSystemInitiated;
    @Column(name = "initiation_time")
    private LocalDateTime initiationTime;
    @Column(name = "inspection_time")
    private LocalDateTime inspectionTime;
    @Column(name = "inspectionCallTimeout")
    private LocalDateTime inspectionCallTimeout;
}
