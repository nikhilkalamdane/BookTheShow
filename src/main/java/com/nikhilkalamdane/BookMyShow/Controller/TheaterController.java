package com.nikhilkalamdane.BookMyShow.Controller;

import com.nikhilkalamdane.BookMyShow.Service.impl.TheaterServiceImpl;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.TheaterEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TheaterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterServiceImpl theaterService;

    @PostMapping("add")
    public ResponseEntity<TheaterResponseDto> addTheater(@RequestBody() TheaterEntryDto theaterEntryDto){
        TheaterResponseDto theaterResponseDto = theaterService.addTheater(theaterEntryDto);
        return new ResponseEntity<>(theaterResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getTheater(@PathVariable Integer id){
        TheaterResponseDto theaterResponseDto = theaterService.getTheater(id);

        if(theaterResponseDto.getId() == 0){
            return new ResponseEntity<>("Theater does not exist with id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(theaterResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAllTheaters(){
        return theaterService.getAllTheaters();
    }

}
