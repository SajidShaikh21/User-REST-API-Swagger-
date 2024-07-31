package com.code.controller;

import com.code.dto.UserDto;
import com.code.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(
        name = "User Controller All CRUD API",
        description = "This is the class that implements all the CRUD API related to user"
)
public class UserController {

    @Autowired
    private UserService userService;


     @Operation(
             summary = "Add User In database",
             description = "Create User In database"
     )
    @PostMapping("/add")
    public ResponseEntity<UserDto>createUser( @RequestBody UserDto userDto)
    {
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }



    @Operation(
            summary = "Find All User From database",
            description = "getting All user from db"
    )
    @GetMapping("/")
    public ResponseEntity<List<UserDto>>getAllusers()
    {
        List<UserDto> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);

    }



    @Operation(
            summary = "Find User By Using user_Id",
            description = "Retrieve User By using user_Id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserDto>getUserById(@PathVariable Integer id)
    {
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }



    @Operation(
            summary = "Update User In dattabse",
            description = "Update Information In Database"
    )
    @PutMapping("/{id}")
    public ResponseEntity<UserDto>updateUser(@PathVariable Integer id, @RequestBody UserDto userDto)
    {
        UserDto updateUser = userService.updateUser(id, userDto);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }



    @Operation(
            summary = "Deleted User",
            description = "Deleted User In databse"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteUser(@PathVariable Integer id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
