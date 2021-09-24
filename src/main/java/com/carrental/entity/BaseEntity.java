package com.carrental.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(name = "STATUS")
    private Long status;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;
}
