package com.boot.poc.controller;

import com.boot.poc.models.version.EmployeeV1;
import com.boot.poc.models.version.EmployeeV2;
import com.boot.poc.models.version.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/versioning")
@RestController
public class DemoVersionController {

    private final MessageSource messageSource;

    @Autowired
    public DemoVersionController(MessageSource messageSource){
        this.messageSource=messageSource;
    }
    // Versioning using different Endpoint (URI Versioning)
    @GetMapping(path = "/employee/v1")
    public EmployeeV1 demoUsingEndpointV1(){
        return new EmployeeV1("Frenklin Roosevelt");
    }

    @GetMapping(path = "/employee/v2")
    public EmployeeV2 demoUsingEndpointV2(){
        return new EmployeeV2(new Name("Frenklin","Roosevelt"));
    }
    // Versioning using REQUEST Params
    @GetMapping(value = "/employee/param",params = "version=1")
    public EmployeeV1 demoUsingRequestParamV1(){
        return new EmployeeV1("Frenklin Roosevelt");
    }

    @GetMapping(value = "/employee/param",params = "version=2")
    public EmployeeV2 demoUsingRequestParamV2(){
        return new EmployeeV2(new Name("Frenklin","Roosevelt"));
    }

    // Versioning using HEADER Params
    @GetMapping(value = "/employee/header",headers = "X-API-VERSION=1")
    public EmployeeV1 demoUsingHeaderParamV1(){
        return new EmployeeV1("Frenklin Roosevelt");
    }

    @GetMapping(value = "/employee/header",headers = "X-API-VERSION=2")
    public EmployeeV2 demoUsingHeaderParamV2(){
        return new EmployeeV2(new Name("Frenklin","Roosevelt"));
    }

    // Versioning using PRODUCES type ( also called ACCEPT header)
    @GetMapping(value = "/employee/produces",produces = "application/vnd.demo.app-v1+json")
    public EmployeeV1 demoUsingProducesV1(){
        return new EmployeeV1("Frenklin Roosevelt");
    }

    @GetMapping(value = "/employee/produces",produces = "application/vnd.demo.app-v2+json")
    public EmployeeV2 demoUsingProducesV2(){
        return new EmployeeV2(new Name("Frenklin","Roosevelt"));
    }

}