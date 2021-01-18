package com.boot.poc.models.version;

public class EmployeeV2 {
    long id;
    Name name;
    public EmployeeV2(Name name){
        this.name=name;
    }

    //Do remember to add Getter to the model POJOs
    public long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }
}
