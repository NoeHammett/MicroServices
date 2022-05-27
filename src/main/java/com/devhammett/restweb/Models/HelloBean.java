package com.devhammett.restweb.Models;

public class HelloBean {

    private String message;

    public HelloBean(String message) {
        this.message = message;
    }
    

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            "}";
    }

}
