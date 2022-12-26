package com.nikhilkalamdane.BookMyShow.Controller;


import com.nikhilkalamdane.BookMyShow.Service.impl.ShowServiceImpl;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.ShowResponseDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TheaterResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody() ShowEntryDto showEntryDto){
        log.info("Here we are");
        return showService.addShow(showEntryDto);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getTheater(@PathVariable Integer id){
        ShowResponseDto showResponseDto = showService.getShow(id);

        if(showResponseDto.getId() == 0){
            return new ResponseEntity<>("Show does not exist with id " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(showResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAllShows(){
        return showService.getAllShows();
    }

}
