package com.boot.poc.controller;

import com.boot.poc.configuration.DBProperties;
import com.boot.poc.models.DBProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoProfileController {

    private final MessageSource messageSource;

    @Value("${default.database.vendor:defaultVendorInController}")
    private String  dbVendor;

    @Value("${demo.database.version:defaultVersionInController}")
    private String  dbVersion;

    private DBProperties dbProperties;

    @Autowired
    public DemoProfileController(MessageSource messageSource,
                                 DBProperties dbProperties){
        this.messageSource=messageSource;
        this.dbProperties=dbProperties;
    }


    @GetMapping(path = "/demoprofile")
    public DBProfileResponse getDBDetail(){
        System.out.println("dbvendor:"+dbVendor);
        System.out.println("dbVersion:"+dbVersion);
        DBProfileResponse response=new DBProfileResponse(dbVendor,dbVersion,
                dbProperties.getHost(),
                dbProperties.getPort(),
                dbProperties.getServiceName(),
                dbProperties.getCredentials(),
                dbProperties.getAdmins(),
                dbProperties.getNlsParams());


        return response;
    }


}