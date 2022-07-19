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
public class FieldSupervisionInputHandle {
    private int supervisorId;
    private int getSuperviseId;
    private int startTime;
    private int endTime;
    private int statusId;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
