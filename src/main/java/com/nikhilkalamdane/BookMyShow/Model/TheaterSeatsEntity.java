package com.nikhilkalamdane.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nikhilkalamdane.BookMyShow.Enum.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Table(name = "theater_seats")
public class TheaterSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat_number", nullable = false)
    private String seatNo;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TheaterEntity theaterEntity;

}
