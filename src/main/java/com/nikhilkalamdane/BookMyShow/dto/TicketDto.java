package com.nikhilkalamdane.BookMyShow.dto;

import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.ShowResponseDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.UserResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


@Data
@Builder
public class TicketDto {
    int id; //ticket id
    //Set<String> allottedSeats;
    String allottedSeats;
    double amount;
    ShowResponseDto showDto;

    @NonNull
    UserResponseDto userDto;
}
