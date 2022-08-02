package com.parika.inspection.manager.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "profile_type")
public class ProfileType extends BaseEntity{
    @Column(name = "profile_type_desc")
    private String profileTypeDesc;
}
