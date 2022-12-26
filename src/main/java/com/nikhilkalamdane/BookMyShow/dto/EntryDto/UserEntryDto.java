package com.nikhilkalamdane.BookMyShow.dto.EntryDto;

import lombok.*;

@Data //getter,setter,noArgsArgument,allArgsArgument
@Builder
public class UserEntryDto {

    @NonNull
    String name;

    @NonNull
    String mobile;
}
