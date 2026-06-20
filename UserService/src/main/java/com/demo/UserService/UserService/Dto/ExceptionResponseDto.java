package com.demo.UserService.UserService.Dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDto {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
}
