package com.demo.hotels.hotels.Dto;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
}
