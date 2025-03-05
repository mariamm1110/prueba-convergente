package com.convergente.pruebaconvergente.services;

import com.convergente.pruebaconvergente.dtos.UserDTO;
import com.convergente.pruebaconvergente.models.User;
import com.convergente.pruebaconvergente.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User createUser(UserDTO userDto) {
        User user = new User();
        user.setName(userDto.name());
        user.setEmail(userDto.email());

        return this.userRepository.save(user);
    }
}
