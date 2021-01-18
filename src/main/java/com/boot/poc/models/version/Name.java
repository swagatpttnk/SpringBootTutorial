package com.boot.poc.models.version;

public class Name {
    String firstName;
    String lastName;
    public Name(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }
    //Do remember to add Getter to the model POJOs
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
