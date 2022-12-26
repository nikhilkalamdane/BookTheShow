package com.nikhilkalamdane.BookMyShow.Converter;

import com.nikhilkalamdane.BookMyShow.Model.MovieEntity;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {

    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){
        return MovieEntity.builder().
                name(movieEntryDto.getName()).
                releaseDate(movieEntryDto.getReleaseDate()).
                build();
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity) {
        return MovieResponseDto.builder().
                id(movieEntity.getId()).
                name(movieEntity.getName()).
                releaseDate(movieEntity.getReleaseDate()).
                build();
    }

    public static MovieNameAndIdObject convertEntityToThisObject(MovieEntity movieEntity){
        return MovieNameAndIdObject.builder().
                id(movieEntity.getId()).
                name(movieEntity.getName()).
                build();
    }
}
