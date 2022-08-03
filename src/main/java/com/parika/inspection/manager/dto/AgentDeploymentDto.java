package com.parika.inspection.manager.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class AgentDeploymentDto {
    private int fieldAgentId;
    private int parkingId;
}
