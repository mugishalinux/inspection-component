package com.parika.inspection.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Size(min = 1, max =10, message = "SLOT ID should not be empty, null and or length exceed 10")
    @JoinColumn(name = "slot_id" , nullable = false)
    private ParkingSlot slotId;
    @ManyToOne
    @Size(min = 1, max =10, message = "FIELD AGENT ID should not be empty, null and or length exceed 10")
    @JoinColumn(name = "field_agent_id", nullable = false)
    private FieldAgents fieldAgents;
    @ManyToOne
    @Size(min = 1, max =10, message = "Vehicle ID should not be empty, null and or length exceed 10")
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
    @Size(max =1, message = "System Initiator status not be empty, null and or length exceed to one character")
    @Column(name = "is_system_initiated")
    private char isSystemInitiated;
    @Column(name = "initiation_time")
    private LocalDateTime initiationTime;
    @Column(name = "inspection_time")
    private LocalDateTime inspectionTime;
    @Column(name = "inspectionCallTimeout")
    private LocalDateTime inspectionCallTimeout;
}
