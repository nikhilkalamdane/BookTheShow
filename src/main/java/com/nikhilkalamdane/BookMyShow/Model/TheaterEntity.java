package com.nikhilkalamdane.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nikhilkalamdane.BookMyShow.Enum.TheaterType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "theaters")
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    TheaterType theaterType;

    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;

    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheaterSeatsEntity> seats = new ArrayList<>();
}
