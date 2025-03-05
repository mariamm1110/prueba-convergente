package com.convergente.pruebaconvergente.services;

import com.convergente.pruebaconvergente.dtos.UserDTO;
import com.convergente.pruebaconvergente.models.User;

import java.util.List;

public interface IUserService {

    List<User> getUsers();

    User createUser(UserDTO userDto);
}
