package com.nikhilkalamdane.BookMyShow.Service;

import com.nikhilkalamdane.BookMyShow.dto.BookTicketRequestDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TicketResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketService {

    //get by id
    ResponseEntity<?> getTicket(int id);

    //book a ticket
    ResponseEntity<?> bookTicket(BookTicketRequestDto bookTicketRequestDto);

    ResponseEntity<?> getAllTickets();
}
