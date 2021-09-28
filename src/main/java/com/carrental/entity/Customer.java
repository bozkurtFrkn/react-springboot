package com.carrental.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "CUSTOMER")
@Entity
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerIdSeq")
    @SequenceGenerator(sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1, name = "CustomerIdSeq")
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @NotNull
    @Column(name = "USER_ID")
    private Long userId;

    @NotNull
    @Column(name = "NATIONALITY")
    private String nationality;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "SURNAME")
    private String surname;

    @NotNull
    @Column(name = "BIRTH_DATE")
    private LocalDateTime birthDate;

    @NotNull
    @Column(name = "DRIVER_LICENSE_NO")
    private String driverLicenseNo;

    @NotNull
    @Column(name = "DRIVER_LICENSE_CLASS")
    private String driverLicenseClass;

    @NotNull
    @Column(name = "PROVINCE_COUNTY")
    private String provinceCounty;

    @NotNull
    @Column(name = "DRIVER_LICENSE_DATE")
    private String driverLicenseDate;

    @NotNull
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
