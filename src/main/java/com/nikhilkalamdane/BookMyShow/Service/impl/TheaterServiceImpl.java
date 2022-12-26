package com.nikhilkalamdane.BookMyShow.Service.impl;

import com.nikhilkalamdane.BookMyShow.Converter.TheaterConverter;
import com.nikhilkalamdane.BookMyShow.Enum.SeatType;
import com.nikhilkalamdane.BookMyShow.Enum.TheaterType;
import com.nikhilkalamdane.BookMyShow.Model.TheaterEntity;
import com.nikhilkalamdane.BookMyShow.Model.TheaterSeatsEntity;
import com.nikhilkalamdane.BookMyShow.Repository.TheaterRepository;
import com.nikhilkalamdane.BookMyShow.Repository.TheaterSeatRepository;
import com.nikhilkalamdane.BookMyShow.Service.TheaterService;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.TheaterEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TheaterResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {
        TheaterEntity theaterEntity = TheaterConverter.convertDtoToEntity(theaterEntryDto);
        List<TheaterSeatsEntity> seats = createTheaterSeats();
        theaterEntity.setSeats(seats);
        theaterEntity.setShows(null);

        for(TheaterSeatsEntity seat : seats){
            seat.setTheaterEntity(theaterEntity);
        }

        theaterEntity.setTheaterType(TheaterType.SINGLE);

        log.info("The theater entity is " + theaterEntity);

        theaterEntity = theaterRepository.save(theaterEntity);
        theaterSeatRepository.saveAll(seats);

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterResponseDto;
    }

    List<TheaterSeatsEntity> createTheaterSeats() {
        List<TheaterSeatsEntity> seats = new ArrayList<>();

        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("2A",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E",200,SeatType.PREMIUM));

        return seats;
    }

    public TheaterSeatsEntity getTheaterSeat(String seatNo, int rate, SeatType seatType) {
        return TheaterSeatsEntity.builder()
                .seatNo(seatNo)
                .seatType(seatType)
                .rate(rate)
                .build();
    }

    @Override
    public TheaterResponseDto getTheater(int id) {
        TheaterEntity theaterEntity = new TheaterEntity();
        try{
            theaterEntity = theaterRepository.findById(id).get();
        }catch(Exception e){
            System.out.println("Theater does not exist with id " + id);
        }

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);
        return theaterResponseDto;
    }

    @Override
    public ResponseEntity<?> getAllTheaters() {
        return new ResponseEntity<>(theaterRepository.findAll(), HttpStatus.ACCEPTED);
    }
}
