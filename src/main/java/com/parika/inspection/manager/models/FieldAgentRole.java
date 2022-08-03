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
@Table(name = "field_agent_role")
public class FieldAgentRole extends BaseEntity{
    @Size(max =10, message = "Agent Role name should not be empty , null or exceed to 10 characters")
    @Column(name="role_name", nullable = false)
    private String roleName;
}
