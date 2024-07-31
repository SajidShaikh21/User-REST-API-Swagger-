package com.code.service;

import com.code.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto>getAllUsers();

    UserDto getUserById( Integer id);

    UserDto updateUser(Integer id,UserDto userDto);

    void deleteUser(Integer id);

}
