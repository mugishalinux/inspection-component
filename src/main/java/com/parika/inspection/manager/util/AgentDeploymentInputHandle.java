package com.parika.inspection.manager.util;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class AgentDeploymentInputHandle {
    private int id;
    private int fieldAgentId;
    private int parkingId;
    private LocalDateTime deploymentStartTime;
    private LocalDateTime getDeploymentEndTime;
    private int statusId;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
