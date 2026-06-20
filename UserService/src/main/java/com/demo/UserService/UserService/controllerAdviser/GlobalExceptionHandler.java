package com.demo.UserService.UserService.controllerAdviser;

import com.demo.UserService.UserService.Dto.ExceptionResponseDto;
import com.demo.UserService.UserService.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto>userNotFound(UserNotFoundException ex){
        String msg=ex.getMessage();
        ExceptionResponseDto messageObj=ExceptionResponseDto.builder().message(msg).error("UserNotFound").status(404).build();
        return new ResponseEntity<>(messageObj,HttpStatus.NOT_FOUND);
    }
}
