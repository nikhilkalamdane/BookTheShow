package com.nikhilkalamdane.BookMyShow.Controller;

import com.nikhilkalamdane.BookMyShow.Service.impl.TicketServiceImpl;
import com.nikhilkalamdane.BookMyShow.dto.BookTicketRequestDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TicketResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping("get/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable Integer id){
        return ticketService.getTicket(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTicket(@RequestBody() BookTicketRequestDto bookTicketRequestDto){
        return ticketService.bookTicket(bookTicketRequestDto);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAllTickets(){
        return ticketService.getAllTickets();
    }

}

