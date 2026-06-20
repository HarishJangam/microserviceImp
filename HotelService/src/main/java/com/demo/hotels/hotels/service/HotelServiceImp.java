package com.demo.hotels.hotels.service;

import com.demo.hotels.hotels.exception.HotelNotFound;
import com.demo.hotels.hotels.models.Hotels;
//import com.demo.hotels.hotels.repository.HotelRepository;
import com.demo.hotels.hotels.repository.HotelsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImp implements HotelService{
    HotelsRepository hotelsRepository;

    public HotelServiceImp(HotelsRepository hotelsRepository){
        this.hotelsRepository=hotelsRepository;
    }
    @Override
    public Hotels createHotel(Hotels hotel) {
        String id= UUID.randomUUID().toString();
        hotel.setHotelId(id);
        return hotelsRepository.save(hotel);
    }

    @Override
    public List<Hotels> getAllHotels() {
        return hotelsRepository.findAll();
    }

    @Override
    public Hotels getHotelById(String hotelId) {
//        return  (Hotels) hotelsRepository.findBy(hotelId).orElseThrow(()->new HotelNotFound("hotel not found"));
        Optional<Hotels>hotel=hotelsRepository.findById(hotelId);
        return hotel.get();
    }
}
