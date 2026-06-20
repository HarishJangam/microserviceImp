package com.demo.UserService.UserService.service;

import com.demo.UserService.UserService.exceptions.UserNotFoundException;
import com.demo.UserService.UserService.models.Rating;
import com.demo.UserService.UserService.models.User;
import com.demo.UserService.UserService.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{


    UserRepository userRepository;
    RestTemplate restTemplate;
    private Logger logger= LoggerFactory.getLogger(UserServiceImp.class);

    public UserServiceImp(UserRepository userRepository,RestTemplate restTemplate){
        this.userRepository=userRepository;
        this.restTemplate=restTemplate;
    }
    @Override
    public User createUser(User user) {
        String id= UUID.randomUUID().toString();
        user.setUserId(id);
        User user1= (User) userRepository.save(user);
//        return null;
        return user1;
    }


    @Override
    public List<User> getAllUsers() {
//        implement rating service call
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) throws Throwable {
        User user= (User) userRepository.findById(id).orElseThrow(()->new UserNotFoundException("UserNotFound"));
//        http://localhost:8082/ratings/users/f7e07dad-d10b-4480-ad02-0bf30dc17844
       ArrayList<Rating> ratings= restTemplate.getForObject("http://localhost:8082/ratings/users/"+user.getUserId() , ArrayList.class);
//       logger.info(String.valueOf(ratings));
       user.setRatings(ratings);
        return user;
    }
}
