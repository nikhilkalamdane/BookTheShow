package com.nikhilkalamdane.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
//@EntityListeners(value = { AuditingEntityListener.class })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "allotted_seats", nullable = false)
    private String allottedSeats;

    @Column(name = "amount", nullable = false)
    private double amount;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at", nullable = false)
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity show;


    @OneToMany(mappedBy = "ticketEntity",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> seats;


}
