package com.parika.inspection.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "profiles_id")
    private Profiles profiles;
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private FieldAgentRole roleId;
}
