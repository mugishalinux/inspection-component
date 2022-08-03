package com.parika.inspection.manager.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkingInspectionDto {
    private int slotId;
    private int fieldAgentId;
    private int vehicleId;
    private char isSystemInitiated;
    private Date initiationTime;
    private Date inspectionTime;
    private Date inspectionCallTimeout;
    private int statusId;
}
