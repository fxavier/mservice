package com.xavier.mservice.model;


import lombok.Getter;

public enum  FreelancerType {

    AGENCY("Agência"),
    INDIVIDUAL("Individual");

    @Getter
    private String description;

    FreelancerType(String description) {
        this.description = description;
    }
}
