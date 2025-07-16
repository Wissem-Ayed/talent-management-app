package com.mytalent.testapp.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatusException(ResponseStatusException ex) {
        HttpStatus status = (HttpStatus) ex.getStatusCode();
        String code;

        if (status == HttpStatus.NOT_FOUND) {
            code = "RESOURCE_NOT_FOUND";
        } else if (status == HttpStatus.BAD_REQUEST) {
            code = "BAD_REQUEST";
        } else if (status == HttpStatus.UNAUTHORIZED) {
            code = "UNAUTHORIZED";
        } else {
            code = "INTERNAL_ERROR";
        }

        return new ResponseEntity<>(new ErrorResponse(code, ex.getReason()), status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> Map.of(
                        "field", error.getField(),
                        "message", error.getDefaultMessage()))
                .toList();

        Map<String, Object> body = Map.of(
                "error_code", HttpStatus.BAD_REQUEST,
                "message", "Validation error",
                "errors", errors
        );

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleOtherExceptions(Exception ex) {
        log.error("Unexpected error occurred", ex);
        return new ResponseEntity<>(new ErrorResponse("INTERNAL_ERROR", "Unexpected error occurred"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
