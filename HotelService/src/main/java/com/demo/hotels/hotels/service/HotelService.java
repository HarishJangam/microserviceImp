package com.demo.hotels.hotels.service;

import com.demo.hotels.hotels.models.Hotels;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HotelService {
    Hotels createHotel(Hotels hotel);
    List<Hotels> getAllHotels();
    Hotels getHotelById(String hotelId);
}
