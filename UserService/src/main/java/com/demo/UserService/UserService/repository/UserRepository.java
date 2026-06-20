package com.demo.UserService.UserService.repository;

import com.demo.UserService.UserService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<user> extends JpaRepository<User, String> {
//    <User> void save(User);
//    User user=save(user);
}
