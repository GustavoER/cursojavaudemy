package com.gustavo.workshop.services.exception;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError {
    private LocalDateTime data;
    private Integer status;
    private String error;
    private String path;
    private String message;
}
