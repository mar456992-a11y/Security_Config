package com.example.security_config.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private T payload;
    private int status;
    private LocalDateTime dateTime;
}
