package com.nikhilkalamdane.BookMyShow.Service.impl;

import com.nikhilkalamdane.BookMyShow.Converter.UserConverter;
import com.nikhilkalamdane.BookMyShow.Model.UserEntity;
import com.nikhilkalamdane.BookMyShow.Repository.UserRepository;
import com.nikhilkalamdane.BookMyShow.Service.UserService;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.UserEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.UserResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userEntryDto) {
        UserEntity userEntity = UserConverter.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {
        UserResponseDto userResponseDto = null;
        UserEntity userEntity;
        try {
            userEntity = userRepository.findById(id).get();
            userResponseDto = UserConverter.convertEntityToDto(userEntity);
            return userResponseDto;
        }catch(Exception e){
            System.out.println("User not exits for id: " + id);
        }

        userResponseDto = UserConverter.convertEntityToDto(new UserEntity());
        return userResponseDto;

    }

    @Override
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.ACCEPTED);
    }
}
