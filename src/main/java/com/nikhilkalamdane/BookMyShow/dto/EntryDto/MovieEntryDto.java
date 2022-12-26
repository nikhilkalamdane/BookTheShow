package com.nikhilkalamdane.BookMyShow.dto.EntryDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

//@Getter
@Data
@Builder
public class MovieEntryDto {
    String name;

    @NonNull
    LocalDate releaseDate;
}
