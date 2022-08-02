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
@Table(name = "PA_DOCUMENT_TYPE_LT")
public class ProfileDocumentType extends BaseEntity{
    private String documentTypeDesc;
}
