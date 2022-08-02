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
@Table(name = "agent_deployments")
public class AgentDeployments extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "field_agent_id")
    private FieldAgents fieldAgents;
    @ManyToOne
    @JoinColumn(name = "parking_area_id")
    private ParkingArea parkingAreaId;

    @Column(name = "deployment_start_time")
    private LocalDateTime deploymentStartTime;
    @Column(name = "deployment_end_time")
    private LocalDateTime deploymentEndTime;
}
