package com.boot.poc.models;


import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    private Integer id;

    @Size(min = 2,max = 10,message = "name should have atleast 2 and max 10 char")
    private String name;

    @Past
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public User(Integer id, String name, Date birthDate){
        super();
        this.id=id;
        this.name=name;
        this.birthDate=birthDate;
    }
    @Override
    public String toString() {
        return String.format("User[id=%s,Name=%s,birthDate=%s]",id,name,birthDate);
    }
}