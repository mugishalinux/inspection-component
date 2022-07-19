package com.parika.inspection.manager.util;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class FieldAgentInputHandel {
    private int id;
    private String roleName;
    private int profileId;
    private LocalDateTime registrationDate;
    private int roleId;
    private int statusId;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
