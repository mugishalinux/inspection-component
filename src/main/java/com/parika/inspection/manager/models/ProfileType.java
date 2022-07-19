package com.parika.inspection.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "PA_PROFILE_TYPE_LT")
public class ProfileType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String profileTypeDesc;
    @Column(name = "status_id")
    private int statusId;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "update_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}
