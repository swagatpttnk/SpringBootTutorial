package com.boot.poc.controller;

import com.boot.poc.excepions.DemoWorldException;
import com.boot.poc.excepions.ExceptionResponse;
import com.boot.poc.excepions.UserNotFoundException;
import com.boot.poc.models.DemoWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.Locale;

@RestController
public class DemoController {

    private final MessageSource messageSource;

    @Autowired
    public DemoController(MessageSource messageSource){
        this.messageSource=messageSource;
    }
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
    @PostMapping(path = "/demo-bean/i18/greetings")
    public DemoWorldBean demoInternationalization(
            @RequestBody String name,
            @RequestHeader(name="Accept-Language") Locale locale){
        Object[] param=new Object[1];param[0]=name;
        String response=messageSource.getMessage("greetings.msg",param,locale);

        return new DemoWorldBean(response);

    }

}