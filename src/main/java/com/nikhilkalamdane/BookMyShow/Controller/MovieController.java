package com.nikhilkalamdane.BookMyShow.Controller;

import com.nikhilkalamdane.BookMyShow.Service.impl.MovieServiceImpl;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("add")
    public MovieResponseDto addMovie(@RequestBody(required = true) MovieEntryDto movieEntryDto){
        MovieResponseDto movieResponseDto = movieService.addMovie(movieEntryDto);
        return movieResponseDto;
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getNameAndId(@PathVariable Integer id){
        MovieNameAndIdObject movieNameAndIdObject = movieService.getNameAndId(id);
        if(movieNameAndIdObject.getId() == 0){
           return new ResponseEntity<>("Movie does not exist with id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movieNameAndIdObject, HttpStatus.FOUND);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAllMovies(){
        return movieService.getAllMovies();
    }
}
