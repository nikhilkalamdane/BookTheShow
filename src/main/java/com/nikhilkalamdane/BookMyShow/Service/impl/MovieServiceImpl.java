package com.nikhilkalamdane.BookMyShow.Service.impl;

import com.nikhilkalamdane.BookMyShow.Converter.MovieConverter;
import com.nikhilkalamdane.BookMyShow.Model.MovieEntity;
import com.nikhilkalamdane.BookMyShow.Repository.MovieRepository;
import com.nikhilkalamdane.BookMyShow.Service.MovieService;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {
        MovieResponseDto movieResponseDto = null;
        if(movieRepository.existsByName(movieEntryDto.getName())){
            movieResponseDto.setName("This movie is already exist");
            return movieResponseDto;
        }
        log.info("In the function add movie" + movieEntryDto);

        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);
        movieEntity = movieRepository.save(movieEntity);
        movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) {
        MovieEntity movieEntity = movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;
    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id) {
        MovieEntity movieEntity = new MovieEntity();
        try{
            movieEntity = movieRepository.findById(id).get();
        }catch(Exception e){
            System.out.println("Movie does not exist with id " + id);
        }

        MovieNameAndIdObject obj = MovieConverter.convertEntityToThisObject(movieEntity);
        return obj;
    }

    @Override
    public ResponseEntity<?> getAllMovies() {
        return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.ACCEPTED);
    }
}
