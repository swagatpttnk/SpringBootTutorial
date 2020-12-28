package com.boot.poc.controller;

import com.boot.poc.models.DemoWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping(path = "/demos")
    public String demoWorld(){
        return "Hello welcome to my Demo";
    }

    @GetMapping(path = "/demo-bean")
    public DemoWorldBean demoWorldBean(){
        return new DemoWorldBean("Hello welcome to my DemoBean");
    }
    @GetMapping(path = "/demo-bean/path-variables/{name}")
    public DemoWorldBean demoPathVariable(@PathVariable String name){
        return new DemoWorldBean(String.format("Path variable demo. Path variable passed:%s",name));
    }
}