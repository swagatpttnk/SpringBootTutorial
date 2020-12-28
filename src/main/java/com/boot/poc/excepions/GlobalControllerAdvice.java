package com.boot.poc.excepions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    //Handle Specific Exception
    @ExceptionHandler({ UserNotFoundException.class })
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException uex, WebRequest request){
        ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), uex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse , HttpStatus.NOT_FOUND);
    }

    //Handle Group of Exception

}
