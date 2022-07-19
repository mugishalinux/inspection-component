package com.parika.inspection.manager.util;

import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.ParkingSlot;
import com.parika.inspection.manager.models.Vehicle;
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
@ToString
public class ParkingIspInputHandle {
    private int id;
    private int slotId;
    private int fieldAgentId;
    private int vehicleId;
    private char isSystemInitiated;
    private LocalDateTime initiationTime;
    private LocalDateTime inspectionTime;
    private LocalTime inspectionCallTimeout;
    private int statusId;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
