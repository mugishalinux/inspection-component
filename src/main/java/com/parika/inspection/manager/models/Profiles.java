package com.parika.inspection.manager.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "profiles")
public class Profiles extends BaseEntity{
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
    private ProfileType ProfileType;
    @ManyToOne()
    @JoinColumn(name = "document_type_id")
    private DocumentType DocumentType;
}
