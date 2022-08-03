package com.parika.inspection.manager.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class FieldSupervisionDto {
    private int supervisorId;
    private int getSuperviseId;
    private int startTime;
    private int endTime;
}
