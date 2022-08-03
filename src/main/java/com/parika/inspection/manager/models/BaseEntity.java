package com.parika.inspection.manager.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", length = 255, nullable = false)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @Column(name = "created_on_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+0")
    private Date createdOnDt;
    @Column(name = "updated_on_dt", nullable = false )
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+0")
    private Date updatedOnDt;
    @Column(name = "createdBy", length = 90, nullable = true)
    private String createdBy;
    @Column(name = "updatedBy", length = 90, nullable = true)
    private String updatedBy;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }
}
