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
@Table(name = "field_agent_role")
public class FieldAgentRole extends BaseEntity{
    @Column(name="role_name")
    private String roleName;
}
