package com.boot.poc.controller;

import com.boot.poc.configuration.DBProperties;
import com.boot.poc.excepions.DemoWorldException;
import com.boot.poc.models.DBProfileResponse;
import com.boot.poc.models.DemoWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class DemoProfileController {

    private final MessageSource messageSource;

    @Value("${default.database.vendor:none}")
    private String  dbVendor;

    private DBProperties dbProperties;

    @Autowired
    public DemoProfileController(MessageSource messageSource,DBProperties dbProperties){
        this.messageSource=messageSource;
        this.dbProperties=dbProperties;
    }


    @GetMapping(path = "/demoprofile")
    public DBProfileResponse getDBDetail(){
        DBProfileResponse response=new DBProfileResponse(dbVendor,
                dbProperties.host,dbProperties.port,dbProperties.serviceName,dbProperties.credentials,dbProperties.admins,dbProperties.nlsParams);
        System.out.println("dbvendor:"+dbVendor);
        response.dbVendor=dbVendor;
        return response;
    }


}