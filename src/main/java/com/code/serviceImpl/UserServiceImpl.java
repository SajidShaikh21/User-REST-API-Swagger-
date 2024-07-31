package com.code.serviceImpl;

import com.code.dto.UserDto;
import com.code.entity.User;
import com.code.repository.UserRepo;
import com.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user=new User(userDto.getId(),userDto.getName(),userDto.getEmail());
        User savedUser = userRepo.save(user);
        return new UserDto(savedUser.getId(),savedUser.getName(),savedUser.getEmail());
    }

    @Override
    public List<UserDto> getAllUsers() {
      return userRepo.findAll().stream().map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
              .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public UserDto updateUser(Integer id, UserDto userDto) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        User save = userRepo.save(user);
        return new UserDto(save.getId(),save.getName(),save.getEmail());
    }

    @Override
    public void deleteUser(Integer id) {
        if (!userRepo.existsById(id)){
            throw new RuntimeException("user not found");
        }
        userRepo.deleteById(id);

    }

}
