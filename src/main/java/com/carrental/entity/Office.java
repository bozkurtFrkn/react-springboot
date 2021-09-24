package com.carrental.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "OFFICE")
public class Office extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OfficeIdSeq")
    @SequenceGenerator(sequenceName = "OFFICE_ID_SEQ", allocationSize = 1, name = "OfficeIdSeq")
    @Column(name = "OFFICE_ID")
    private Long officeId;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @NotNull
    @Column(name = "ADDRESS")
    private String address;
}
