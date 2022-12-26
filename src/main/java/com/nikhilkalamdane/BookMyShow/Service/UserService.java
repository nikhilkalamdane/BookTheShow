package com.nikhilkalamdane.BookMyShow.Service;

import com.nikhilkalamdane.BookMyShow.dto.EntryDto.UserEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.UserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    //add
    void addUser(UserEntryDto userEntryDto);

    //get
    UserResponseDto getUser(int id);

    ResponseEntity<?> getAllUsers();
}
