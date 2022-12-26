package com.nikhilkalamdane.BookMyShow.dto;

import com.nikhilkalamdane.BookMyShow.Enum.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketRequestDto {
    int id; //user id
    int showId;
    SeatType seatType;
    Set<String> requestedSeats;
}
