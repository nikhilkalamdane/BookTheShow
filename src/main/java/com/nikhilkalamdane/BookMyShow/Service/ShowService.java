package com.nikhilkalamdane.BookMyShow.Service;

import com.nikhilkalamdane.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.ShowResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShowService {

    //add
    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    //get
    ShowResponseDto getShow(int id);

    ResponseEntity<?> getAllShows();
}
