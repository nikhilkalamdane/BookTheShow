package com.nikhilkalamdane.BookMyShow.dto.EntryDto;

import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.MovieResponseDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.TheaterResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDto {

    @NonNull
    LocalDate showDate;

    @NonNull
    LocalTime showTime;

    @NonNull
    MovieResponseDto movieResponseDto;

    @NonNull
    TheaterResponseDto theaterResponseDto;

}
