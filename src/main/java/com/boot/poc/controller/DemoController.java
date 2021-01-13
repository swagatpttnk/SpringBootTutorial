package com.boot.poc.controller;

import com.boot.poc.excepions.DemoWorldException;
import com.boot.poc.excepions.ExceptionResponse;
import com.boot.poc.excepions.UserNotFoundException;
import com.boot.poc.models.DemoWorldBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
public class DemoController {
    // This is a simple GET request
    @GetMapping(path = "/demos")
    public String demoWorld(){
        return "Hello welcome to my Demo";
    }
    // This is a simple GET request
    @GetMapping(path = "/demo-bean")
    public DemoWorldBean demoWorldBean(){
        return new DemoWorldBean("Hello welcome to my DemoBean");
    }
    // Example for path variables
    @GetMapping(path = "/demo-bean/path-variables/{name}")
    public DemoWorldBean demoPathVariable(@PathVariable String name){
        return new DemoWorldBean(String.format("Path variable demo. Path variable passed:%s",name));
    }
    @PostMapping(path = "/demo-bean/greetings")
    public DemoWorldBean demoLocalExceptionHandler(@RequestBody String msg){
        if(msg.contains("Hi")) {
            return new DemoWorldBean("There is a greetings for you:"+msg);
        }else{
            throw new DemoWorldException("This is exception specific to the DemoWorld Controller");
        }
    }

}