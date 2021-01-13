package com.boot.poc.excepions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.Date;
@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    //Handle Specific Exception
    @ExceptionHandler({ UserNotFoundException.class })
    public final ResponseEntity<Object> handleUserNotFoundExceptionExplicit(UserNotFoundException uex, WebRequest request){
        ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), uex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse , HttpStatus.NOT_FOUND);
    }

    //Handle Group of Exception
    @ExceptionHandler({ Exception.class })
    public final ResponseEntity<Object> handleAllException(Exception uex, WebRequest request) {
        if (uex instanceof IOException) {
            return handleIOException(uex, request);
        }if (uex instanceof UserNotFoundException) {
            return handleUserNotFoundException((UserNotFoundException)uex, request);
        }else{
            return handleDefaultException(uex, request);
        }

    }

        ResponseEntity<Object> handleIOException(Exception uex, WebRequest request){
            ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), uex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
        }
    ResponseEntity<Object> handleDefaultException(Exception uex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), uex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException uex, WebRequest request){
        ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), uex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse , HttpStatus.NOT_FOUND);
    }
}
