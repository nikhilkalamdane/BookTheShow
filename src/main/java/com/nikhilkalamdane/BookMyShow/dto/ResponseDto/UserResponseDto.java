package com.nikhilkalamdane.BookMyShow.dto.ResponseDto;

import com.nikhilkalamdane.BookMyShow.dto.TicketDto;
import lombok.*;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    private int id;
    private String name;
    private String mobile;
    List<TicketDto> tickets;
}
