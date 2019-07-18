package com.example.polls.advice;

import com.example.polls.exception.AppException;
import com.example.polls.exception.InvalidTokenRequestException;
import com.example.polls.exception.ResourceAlreadyInUseException;
import com.example.polls.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class AuthControllerAdvice{

    @ExceptionHandler(value = InvalidTokenRequestException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ApiResponse handleInvalidTokenException(InvalidTokenRequestException ex) {
        return new ApiResponse(false, ex.getMessage());
    }

    @ExceptionHandler(value = AppException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse handleAppException(AppException ex) {
        return new ApiResponse(false, ex.getMessage());
    }

    @ExceptionHandler(value = ResourceAlreadyInUseException.class)
    @ResponseStatus(HttpStatus.IM_USED)
    public ApiResponse handleResourceAlreadyInUseException(ResourceAlreadyInUseException ex) {
        return new ApiResponse(false, ex.getMessage());
    }
}
