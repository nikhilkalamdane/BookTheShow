package com.nikhilkalamdane.BookMyShow.Service.impl;

import com.nikhilkalamdane.BookMyShow.Converter.ShowConverter;
import com.nikhilkalamdane.BookMyShow.Model.*;
import com.nikhilkalamdane.BookMyShow.Repository.*;
import com.nikhilkalamdane.BookMyShow.Service.ShowService;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.ShowResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowSeatsRepository showSeatsRepository;
    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowResponseDto getShow(int id){
        ShowEntity showEntity = new ShowEntity();

        try{
            showEntity = showRepository.findById(id).get();
        }catch (Exception e){
            System.out.println("Show does not exist with id " + id);
        }

        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity);
        return showResponseDto;
    }

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);
        log.info("In add show");

        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();
        showEntity.setMovieEntity(movieEntity);
        log.info("In add show 1");
        TheaterEntity theaterEntity = theaterRepository.findById(showEntryDto.getTheaterResponseDto().getId()).get();
        showEntity.setTheaterEntity(theaterEntity);
        log.info("In add show 2");
        showEntity =  showRepository.save(showEntity);
        log.info("In add show 3");
        List<ShowSeatsEntity> seats = generateShowEntitySeats(theaterEntity.getSeats(), showEntity);
        showSeatsRepository.saveAll(seats);
        log.info("In add show 4");
        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity, showEntryDto);

        log.info("complete add show");
        return showResponseDto;

    }

    @Override
    public ResponseEntity<?> getAllShows() {
        return new ResponseEntity<>(showRepository.findAll(), HttpStatus.ACCEPTED);
    }

    public List<ShowSeatsEntity> generateShowEntitySeats(List<TheaterSeatsEntity> theaterSeats, ShowEntity showEntity){

        List<ShowSeatsEntity> showSeats = new ArrayList<>();
        for(TheaterSeatsEntity seat: theaterSeats){
            ShowSeatsEntity showSeat = ShowSeatsEntity.builder()
                    .seatNo(seat.getSeatNo())
                    .seatType(seat.getSeatType())
                    .rate(seat.getRate())
                    .bookedAt(new Date())
                    .build();
            showSeats.add(showSeat);
        }

        for(ShowSeatsEntity showSeatsEntity: showSeats){
            showSeatsEntity.setShowEntity(showEntity);
        }

        showEntity.setShowSeatsEntityList(showSeats);
        return showSeats;
    }
}
