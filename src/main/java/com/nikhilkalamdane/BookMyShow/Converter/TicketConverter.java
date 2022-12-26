package com.nikhilkalamdane.BookMyShow.Converter;

import com.nikhilkalamdane.BookMyShow.Model.TicketEntity;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TicketResponseDto;
import com.nikhilkalamdane.BookMyShow.dto.TicketDto;

public class TicketConverter {
    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity) {

        return TicketResponseDto.builder()
                .id((int) ticketEntity.getId())
                .amount(ticketEntity.getAmount())
                .allotted_seats(ticketEntity.getAllottedSeats().toString())
                .build();
    }
}
