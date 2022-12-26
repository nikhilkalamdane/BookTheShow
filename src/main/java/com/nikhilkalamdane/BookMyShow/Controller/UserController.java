package com.nikhilkalamdane.BookMyShow.Controller;

import com.nikhilkalamdane.BookMyShow.Repository.UserRepository;
import com.nikhilkalamdane.BookMyShow.Service.impl.UserServiceImpl;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.UserEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("add")
    public ResponseEntity<String> addUser(@RequestBody(required = true) UserEntryDto userEntryDto){
        userService.addUser(userEntryDto);
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getUser(@PathVariable(value = "id") int id){
        UserResponseDto userResponseDto = userService.getUser(id);
        if(userResponseDto.getId() == 0){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAllUsers(){
        return userService.getAllUsers();
    }
}
