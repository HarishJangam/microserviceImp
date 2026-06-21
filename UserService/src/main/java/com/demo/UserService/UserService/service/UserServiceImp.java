package com.demo.UserService.UserService.service;

import com.demo.UserService.UserService.exceptions.UserNotFoundException;
import com.demo.UserService.UserService.externalCom.HotelServiceComm;
import com.demo.UserService.UserService.externalCom.RatingServiceComm;
import com.demo.UserService.UserService.models.Hotel;
import com.demo.UserService.UserService.models.Rating;
import com.demo.UserService.UserService.models.User;
import com.demo.UserService.UserService.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService{


    UserRepository userRepository;
    RestTemplate restTemplate;
    HotelServiceComm hotelServiceComm;
    RatingServiceComm ratingServiceComm;
    private Logger logger= LoggerFactory.getLogger(UserServiceImp.class);

    public UserServiceImp(UserRepository userRepository,RestTemplate restTemplate,HotelServiceComm hotelServiceComm ,RatingServiceComm ratingServiceComm){
        this.userRepository=userRepository;
        this.restTemplate=restTemplate;
        this.hotelServiceComm=hotelServiceComm;
        this.ratingServiceComm=ratingServiceComm;
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
        Optional<User> userObj=userRepository.findById(id);
        User user=userObj.get();
//        User user= (User) userRepository.findById(id).orElseThrow(()->new UserNotFoundException("UserNotFound"));
//        http://localhost:8082/ratings/users/f7e07dad-d10b-4480-ad02-0bf30dc17844
        Rating[] ratings = restTemplate.getForObject(
                "http://RATINGSERVICE/ratings/users/" + user.getUserId(),
                Rating[].class
        );
//        List<Rating> ratings=ratingServiceComm.getRating(user.getUserId());

        List<Rating> ratingList = Arrays.stream(ratings)
                .map(rating -> {
//                    Hotel hotel = restTemplate.getForObject(
//                            "http://HOTELS/hotels/" + rating.getHotelId(),
//                            Hotel.class
//                    );
//                    replaced with feignclient
                    Hotel hotel=hotelServiceComm.getHotel(rating.getHotelId());
                    rating.setHotel(hotel);
                    return rating;
                })
                .toList();
        user.setRatings(ratingList);
        return user;
    }
}
