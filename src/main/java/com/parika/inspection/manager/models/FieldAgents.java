package com.parika.inspection.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "field_agents")
public class FieldAgents extends BaseEntity{
    @ManyToOne
    @Size(min = 1, max = 10, message = "PROFILE ID should not be empty or null")
    @JoinColumn(name = "profiles_id", nullable = false)
    private Profiles profiles;
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;
    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    @Size(min = 1, max = 10, message = "PROFILE ID should not be empty or null")
    private FieldAgentRole roleId;
}
