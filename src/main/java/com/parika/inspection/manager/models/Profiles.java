package com.parika.inspection.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "PA_PROFILES_CT")
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "document_id")
    private BigInteger documentId;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    private String email;
    @ManyToOne()
    @JoinColumn(name = "profile_type_id")
    private ProfileType paProfileTypeLt;
    @ManyToOne()
    @JoinColumn(name = "document_type_id")
    private ProfileDocumentType paDocumentTypeLt;
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
