package com.parika.inspection.manager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "village")
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @JoinColumn(name = "cell_id")
    private Cell cell;
//    private int code;
//    private String status;
//    private String createdBy;
//    private LocalDate createdAt = LocalDate.now();
//    private LocalDate updatedAt = LocalDate.now();
}