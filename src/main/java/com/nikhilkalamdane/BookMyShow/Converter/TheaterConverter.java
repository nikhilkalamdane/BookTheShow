package com.nikhilkalamdane.BookMyShow.Converter;

import com.nikhilkalamdane.BookMyShow.Model.TheaterEntity;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.TheaterEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TheaterResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){
        return TheaterEntity.builder()
                .name(theaterEntryDto.getName())
                .address(theaterEntryDto.getAddress())
                .city(theaterEntryDto.getCity())
                .build();
    }

    public static TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity){
        return TheaterResponseDto.builder().
                id(theaterEntity.getId()).
                name(theaterEntity.getName()).
                city(theaterEntity.getCity()).
                address(theaterEntity.getAddress()).
                type(theaterEntity.getTheaterType()).
                build();
    }
}
