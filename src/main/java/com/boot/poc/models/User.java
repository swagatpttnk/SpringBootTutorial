package com.boot.poc.models;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
@ApiModel(description = "User is entity used for representing an Employee")
public class User {
    private Integer id;

    @ApiModelProperty(notes = "name of the user")
    @Size(min = 2,max = 10,message = "name should have atleast 2 and max 10 char")
    private String name;

    @ApiModelProperty(notes = "Dat Of Birth of the user,should be in past")
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