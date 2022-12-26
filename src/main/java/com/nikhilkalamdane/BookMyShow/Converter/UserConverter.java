package com.nikhilkalamdane.BookMyShow.Converter;

import com.nikhilkalamdane.BookMyShow.Model.UserEntity;
import com.nikhilkalamdane.BookMyShow.dto.EntryDto.UserEntryDto;
import com.nikhilkalamdane.BookMyShow.dto.ResponseDto.UserResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){
        return UserEntity.builder()
                .name(userEntryDto.getName())
                .mobile(userEntryDto .getMobile())
                .build();
    }

    public static UserResponseDto convertEntityToDto(UserEntity userEntity){
        return UserResponseDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .mobile(userEntity.getMobile())
                .build();
    }
}
