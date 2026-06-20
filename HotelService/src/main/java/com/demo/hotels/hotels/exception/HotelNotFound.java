package com.demo.hotels.hotels.exception;


public class HotelNotFound extends RuntimeException{
    public HotelNotFound(){
        super("HotelNotFound");
    }
    public HotelNotFound(String msg){
        super(msg);
    }
}
