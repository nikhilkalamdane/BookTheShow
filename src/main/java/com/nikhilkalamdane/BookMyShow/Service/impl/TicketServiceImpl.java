package com.nikhilkalamdane.BookMyShow.Service.impl;

import com.nikhilkalamdane.BookMyShow.Converter.TicketConverter;
import com.nikhilkalamdane.BookMyShow.Model.ShowEntity;
import com.nikhilkalamdane.BookMyShow.Model.ShowSeatsEntity;
import com.nikhilkalamdane.BookMyShow.Model.TicketEntity;
import com.nikhilkalamdane.BookMyShow.Model.UserEntity;
import com.nikhilkalamdane.BookMyShow.Repository.ShowRepository;
import com.nikhilkalamdane.BookMyShow.Repository.TicketRepository;
import com.nikhilkalamdane.BookMyShow.Repository.UserRepository;
import com.nikhilkalamdane.BookMyShow.Service.TicketService;
import com.nikhilkalamdane.BookMyShow.dto.BookTicketRequestDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TicketResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TicketRepository ticketRepository;


    @Override
    public ResponseEntity<?> getTicket(int id) {
        TicketEntity ticketEntity = null;
        try{
            ticketEntity = ticketRepository.findById(id).get();
        }catch(Exception e){
            System.out.println("Ticket does not exist with id " + id);
            return new ResponseEntity<>("Ticket does not exist with id " + id, HttpStatus.NOT_FOUND);
        }
        TicketResponseDto ticketResponseDto = TicketConverter.convertEntityToDto(ticketEntity);
        return new ResponseEntity<>(ticketResponseDto, HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<?> bookTicket(BookTicketRequestDto bookTicketRequestDto) {

        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        log.info("Ticket half processed");

        Set<String> requestedSeats = bookTicketRequestDto.getRequestedSeats();

        List<ShowSeatsEntity> showSeatEntityList = showEntity.getShowSeatsEntityList();

        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity seat: showSeatEntityList){
            if(!seat.isBooked() && seat.getSeatType().equals(bookTicketRequestDto.getSeatType())
                    && requestedSeats.contains(seat.getSeatNo())) {
                bookedSeats.add(seat);
            }
        }



        if(bookedSeats.size() != requestedSeats.size()){
            return new ResponseEntity<>("All Seats not available", HttpStatus.NOT_FOUND);
        }

        TicketEntity ticketEntity = TicketEntity.builder()
                .user(userEntity)
                .show(showEntity)
                .seats(bookedSeats)
                .build();

        double amount = 0;

        for(ShowSeatsEntity seat: bookedSeats){
            seat.setBooked(true);
            seat.setBookedAt(new Date());
            seat.setTicketEntity(ticketEntity);

            amount += seat.getRate();
        }

        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAmount(amount);
        ticketEntity.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));

        showEntity.getTicketEntityList().add(ticketEntity);
        userEntity.getTicketEntityList().add(ticketEntity);
        ticketEntity = ticketRepository.save(ticketEntity);

        return new ResponseEntity<>(TicketConverter.convertEntityToDto(ticketEntity), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllTickets() {
        return new ResponseEntity<>(ticketRepository.findAll(), HttpStatus.ACCEPTED);
    }

    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){
        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){
            str += showSeatsEntity.getSeatNo()+" ";
        }
        return str;
    }
}
