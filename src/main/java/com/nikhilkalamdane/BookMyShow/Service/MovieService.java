package com.nikhilkalamdane.BookMyShow.Service;

import com.nikhilkalamdane.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    //add
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);

    //get
    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);

    ResponseEntity<?> getAllMovies();
}
