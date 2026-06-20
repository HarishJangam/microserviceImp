package com.demo.hotels.hotels.controllerAdvise;

import com.demo.hotels.hotels.Dto.ExceptionResponse;
import com.demo.hotels.hotels.exception.HotelNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(HotelNotFound.class)
    public ResponseEntity<ExceptionResponse>hotelNotFoundException(HotelNotFound hotelNotFound){
        ExceptionResponse res=ExceptionResponse.builder().error(hotelNotFound.getMessage()).error("HotelNotFound").status(404).build();
        return  new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }
}
