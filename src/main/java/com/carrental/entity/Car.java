package com.carrental.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "CAR")
@Entity
public class Car extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CarIdSeq")
    @SequenceGenerator(sequenceName = "CAR_ID_SEQ", allocationSize = 1, name = "CarIdSeq")
    @Column(name = "CAR_ID")
    private Long carId;

    @NotNull
    @Column(name = "CLASS_ID")
    private Long classId;

    @NotNull
    @Column(name = "BRAND")
    private String brand;

    @NotNull
    @Column(name = "SERIES")
    private String series;

    @NotNull
    @Column(name = "MODEL")
    private String model;

    @NotNull
    @Column(name = "YEAR")
    private Long year;

    @NotNull
    @Column(name = "COLOR")
    private String color;

    @NotNull
    @Column(name = "FUEL")
    private String fuel;

    @NotNull
    @Column(name = "GEAR")
    private String gear;

    @NotNull
    @Column(name = "BODY_TYPE")
    private String bodyType;

    @NotNull
    @Column(name = "ENGINE_POWER")
    private Long enginePower;

    @NotNull
    @Column(name = "ENGINE_CAPASITY")
    private BigDecimal engineCapasity;

    @NotNull
    @Column(name = "SEATS")
    private Long seats;

    @NotNull
    @Column(name = "BAGGAGE")
    private String baggage;

    @NotNull
    @Column(name = "DEPOSIT")
    private BigDecimal deposit;
}
