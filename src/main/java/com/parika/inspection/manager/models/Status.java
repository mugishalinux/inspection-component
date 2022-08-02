package com.parika.inspection.manager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "status_desc")
    private String statusDesc;
    @Column(name = "row_status_id")
    private int rowStatusId;
}
