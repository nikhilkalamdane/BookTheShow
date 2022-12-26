package com.nikhilkalamdane.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nikhilkalamdane.BookMyShow.Enum.SeatType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "show_seats")
public class ShowSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Column(name = "seat_number", nullable = false)
    private String seatNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @Column(name = "booked", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at", nullable = false)
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    private TicketEntity ticketEntity;

    @ManyToOne
    @JsonIgnore
    private ShowEntity showEntity;
}
