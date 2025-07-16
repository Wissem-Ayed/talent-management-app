package com.mytalent.testapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ErrorResponse {
    private String error_code;
    private String message;

    public ErrorResponse(String error_code, String message) {
        this.error_code = error_code;
        this.message = message;
    }

}