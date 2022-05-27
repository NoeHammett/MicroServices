package com.devhammett.restweb.Models;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserModel {
    
    private Integer id_user;

    @Size(min = 2, max = 30)
    private String name;
    private String lastname;

    @Email
    private String email;
    
    //Hide the field from the response and request
    //@JsonIgnore
    //Better Use
    @JsonProperty(access = Access.WRITE_ONLY)
    @Past
    private Date birthdate;


    public UserModel() {
    }

    public UserModel(Integer id_user, String name, String lastname, String email, Date birthdate) {
        this.id_user = id_user;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
    }

    public Integer getId_user() {
        return this.id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public String toString() {
        return "{" +
            " id_user='" + getId_user() + "'" +
            ", name='" + getName() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", email='" + getEmail() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            "}";
    }

}
