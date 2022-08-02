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
@Table(name = "document_type")
public class DocumentType extends BaseEntity{
    @Column(name = "document_type_desc")
    private String documentTypeDesc;
}
