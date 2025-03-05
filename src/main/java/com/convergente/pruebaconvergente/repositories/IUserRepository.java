package com.convergente.pruebaconvergente.repositories;

import com.convergente.pruebaconvergente.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {

}
