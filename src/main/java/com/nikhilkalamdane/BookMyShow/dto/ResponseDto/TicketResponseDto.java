package com.nikhilkalamdane.BookMyShow.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {
    int id;
    String allotted_seats;
    double amount;
}
