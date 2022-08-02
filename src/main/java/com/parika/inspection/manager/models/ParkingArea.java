package com.parika.inspection.manager.models;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "Parking_Area")
public class ParkingArea extends BaseEntity{
    @Column(name = "parking_name")
    private String parkingName;
    @ManyToOne
    @JoinColumn(name = "village_code")
    private Village village;
    @Column(name="street_name")
    private String streetName;
    private String latitude;
    private String longitude;
}
