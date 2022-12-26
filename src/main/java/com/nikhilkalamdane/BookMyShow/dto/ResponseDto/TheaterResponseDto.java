package com.nikhilkalamdane.BookMyShow.dto.ResponseDto;

import com.nikhilkalamdane.BookMyShow.Enum.TheaterType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterResponseDto {
    int id;
    String name;
    String address;
    String city;
    TheaterType type;
}
