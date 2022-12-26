package com.nikhilkalamdane.BookMyShow.Service;

import com.nikhilkalamdane.BookMyShow.dto.EntryDto.TheaterEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TheaterResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TheaterService {

    TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);

    TheaterResponseDto getTheater(int id);

    ResponseEntity<?> getAllTheaters();
}
