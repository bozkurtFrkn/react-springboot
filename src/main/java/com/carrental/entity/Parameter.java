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
@Table(name = "PARAMETER")
@Entity
public class Parameter extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ParameterIdSeq")
    @SequenceGenerator(sequenceName = "PARAMETER_ID_SEQ", allocationSize = 1, name = "ParameterIdSeq")
    @Column(name = "PARAMETER_ID")
    private Long parameterId;

    @NotNull
    @Column(name = "GROUP_CODE")
    private String groupCode;

    @NotNull
    @Column(name = "KEY")
    private String key;

    @NotNull
    @Column(name = "VALUE")
    private String value;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;
}
