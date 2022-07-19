package com.parika.inspection.manager.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@ToString
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
//    private int code;
//    private String status;
//    private String createdBy;
//    private LocalDate createdAt = LocalDate.now();
//    private LocalDate updatedAt = LocalDate.now();
}