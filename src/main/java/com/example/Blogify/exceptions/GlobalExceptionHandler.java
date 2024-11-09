package com.example.Blogify.exceptions;

import com.example.Blogify.utils.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {

        String message = resourceNotFoundException.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> allError = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {

            String filedName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            allError.put(filedName, errorMessage);
        });
        return new ResponseEntity<>(allError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiResponse>noResourceFoundException(NoResourceFoundException ex)
    {
        String path=ex.getResourcePath();
        String message=String.format("The requested resource is invalid %s",path);
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> dataIntegrityViolationException(DataIntegrityViolationException ex)
    {
        String message = ex.getMessage();
        String extractMessage = extractDuplicateKeyErrorMessage(message);


        ApiResponse apiResponse = new ApiResponse(extractMessage , false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CONFLICT);
    }

    private static String extractDuplicateKeyErrorMessage(String fullErrorMessage) {
        String regex = "\\(.*?\\)=\\(.*?\\) already exists";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fullErrorMessage);
        if (matcher.find()) {
            return matcher.group();
        }

        // Return a default message if the pattern is not found
        return "Duplicate key error message not found.";

    }


}
