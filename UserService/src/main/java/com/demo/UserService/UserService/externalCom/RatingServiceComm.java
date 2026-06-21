package com.demo.UserService.UserService.externalCom;

import com.demo.UserService.UserService.models.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RATINGSERVICE")
public interface RatingServiceComm {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRating(@PathVariable String userId);
}
