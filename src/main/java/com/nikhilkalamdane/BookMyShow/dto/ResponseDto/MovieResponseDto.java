package com.nikhilkalamdane.BookMyShow.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieResponseDto {

    @NonNull
    int id;
    String name;
    LocalDate releaseDate;

    //Optional
    List<ShowResponseDto> showDtoList;
}
