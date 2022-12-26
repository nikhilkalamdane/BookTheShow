package com.nikhilkalamdane.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
//@EntityListeners(value = {AuditingEntityListener.class})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "shows")
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "show_date", columnDefinition = "DATE", nullable = false)
    private LocalDate showDate;

    @Column(name = "show_time", columnDefinition = "DATE", nullable = false)
    private LocalTime showTime;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;


    @ManyToOne
    @JsonIgnore
    private MovieEntity movieEntity;

    @ManyToOne
    @JsonIgnore
    private TheaterEntity theaterEntity;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity> ticketEntityList;

    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> showSeatsEntityList;

}
