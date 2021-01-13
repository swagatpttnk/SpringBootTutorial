package com.boot.poc.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
//@JsonIgnoreProperties(value={"speciality"})
@ApiModel(description = "Patient is entity used for representing an patient")
public class Doctor {
    private Integer id;

    @ApiModelProperty(notes = "name of the patient")
    @Size(min = 2,max = 10,message = "name should have atleast 2 and max 10 char")
    private String name;

    @ApiModelProperty(notes = "Dat Of Birth of the user,should be in past")
    @Past
    private Date birthDate;

    //@JsonIgnore
    private String speciality ;


    public void setSpeciality(String bloodGroup){
         this.speciality=speciality;
    }
    public String getSpeciality(){
        return this.speciality;
    }

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
    public Doctor(Integer id, String name, Date birthDate, String speciality){
        super();
        this.id=id;
        this.name=name;
        this.birthDate=birthDate;
        this.speciality=speciality;
    }
    @Override
    public String toString() {
        return String.format("User[id=%s,Name=%s,birthDate=%s,speciality=%s]",id,name,birthDate,speciality);
    }
}