package com.carrental.entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "RESERVATION")
@Entity
public class Reservation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReservationIdSeq")
    @SequenceGenerator(sequenceName = "RESERVATION_ID_SEQ", allocationSize = 1, name = "ReservationIdSeq")
    @Column(name = "RESERVATION_ID")
    private Long reservationId;

    @NotNull
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @NotNull
    @Column(name = "CAR_ID")
    private Long carId;

    @NotNull
    @Column(name = "PICKUP_LOCATION_ID")
    private Long pickupLocationId;

    @NotNull
    @Column(name = "PICKUP_DATE")
    private LocalDateTime pickupDate;

    @NotNull
    @Column(name = "RETURN_LOCATION_ID")
    private Long returnLocationId;

    @NotNull
    @Column(name = "RETURN_DATE")
    private LocalDateTime returnDate;

    @NotNull
    @Column(name = "AMOUNT")
    private BigDecimal amount;
}
