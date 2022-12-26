package com.nikhilkalamdane.BookMyShow.dto.EntryDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterEntryDto {
    private String name;
    private String city;
    private String address;
}
