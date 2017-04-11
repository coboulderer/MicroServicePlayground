package com.example.hateoas;

import org.springframework.hateoas.ResourceSupport;

/**
 * Entity
 */
public class Greet extends ResourceSupport {

    private String message;

    public Greet(){}

    public Greet(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
