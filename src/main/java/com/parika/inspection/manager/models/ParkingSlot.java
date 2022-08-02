package com.parika.inspection.manager.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "Parking_Slot")
public class ParkingSlot extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "parking_area_id")
    private ParkingArea parkingAreaId;
    @Column(name = "slot_name")
    private String slotName;
    @Column(name = "sensor_id")
    private int sensorId;
    @Column(name = "parking_start_time")
    private LocalTime parkingStartTime;
}
