package com.carrental.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CAR")
public class Car {
    @Id
    @Column(name = "CAR_ID")
    private Long carId;

    @Column(name = "CLASS_ID")
    private Long classId;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "SERIES")
    private String series;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "DEPOSIT")
    private BigDecimal deposit;

    @Column(name = "STATUS")
    private String status;
}
