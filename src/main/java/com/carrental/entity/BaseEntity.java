package com.carrental.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_DATE")
    private LocalDate updatedDate;
}
