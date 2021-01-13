package com.boot.poc.models;


import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
//@JsonFilter("MyHospitalFilter")
@ApiModel(description = "Patient is entity used for representing an patient")
public class Patient {
    private Integer id;

    @ApiModelProperty(notes = "name of the patient")
    @Size(min = 2,max = 10,message = "name should have atleast 2 and max 10 char")
    private String name;

    @ApiModelProperty(notes = "Dat Of Birth of the user,should be in past")
    @Past
    private Date birthDate;

    private String sickness ;

    private String bloodGroup;

    public void setBloodGroup(String bloodGroup){
         this.bloodGroup=bloodGroup;
    }
    public void setSickness(String sickness){
        this.sickness=sickness;
    }
    public String getBloodGroup(){
        return this.bloodGroup;
    }
    public String getSickness(){
        return this.sickness;
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
    public Patient(Integer id, String name, Date birthDate,String sickness,String bloodGroup){
        super();
        this.id=id;
        this.name=name;
        this.birthDate=birthDate;
        this.sickness=sickness;
        this.bloodGroup=bloodGroup;
    }
    @Override
    public String toString() {
        return String.format("User[id=%s,Name=%s,birthDate=%s,]",id,name,birthDate);
    }
}