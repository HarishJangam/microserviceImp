package com.demo.UserService.UserService.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("UserNotFoundE");
    }
    public UserNotFoundException(String message){
        super(message);
    }

}
