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
@Table(name = "CAR_CLASS")
@Entity
public class CarClass extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ClassIdSeq")
    @SequenceGenerator(sequenceName = "CLASS_ID_SEQ", allocationSize = 1, name = "ClassIdSeq")
    @Column(name = "CLASS_ID")
    private Long classId;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "COST_PER_DAY")
    private BigDecimal costPerDay;

    @NotNull
    @Column(name = "MIN_AGE")
    private Long minAge;

    @NotNull
    @Column(name = "MIN_LICENSE_YEAR")
    private Long minLicenseYear;

    @NotNull
    @Column(name = "LIMIT_OF_KM")
    private Long limitOfKm;
}
