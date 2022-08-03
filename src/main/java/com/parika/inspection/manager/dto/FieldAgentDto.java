package com.parika.inspection.manager.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class FieldAgentDto {
    private String roleName;
    private int profileId;
    private LocalDateTime registrationDate;
    private int roleId;
}
