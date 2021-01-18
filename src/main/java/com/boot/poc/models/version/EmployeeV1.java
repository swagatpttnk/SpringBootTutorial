package com.boot.poc.models.version;

public class EmployeeV1 {
    long id;
    String name;
    public EmployeeV1(String name){
        this.name=name;
    }
    //Do remember to add Getter to the model POJOs
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
