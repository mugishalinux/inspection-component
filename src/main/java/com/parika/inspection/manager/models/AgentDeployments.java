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
@Table(name = "agent_deployments")
public class AgentDeployments extends BaseEntity{
    @ManyToOne
    @Size(min = 1, max = 10, message = "Field AGENT ID should not be empty, null and or length exceed 10")
    @JoinColumn(name = "field_agent_id", nullable = false)
    private FieldAgents fieldAgents;
    @ManyToOne
    @Size(min = 1, max = 10, message = "PARKING AREA ID should not be empty, null and or length exceed 10")
    @JoinColumn(name = "parking_area_id", nullable = false)
    private ParkingArea parkingAreaId;
    @Column(name = "deployment_start_time")
    private LocalDateTime deploymentStartTime;
    @Column(name = "deployment_end_time")
    private LocalDateTime deploymentEndTime;
}
