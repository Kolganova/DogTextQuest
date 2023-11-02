package com.kolganova.http.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {

    static User INSTANCE = new User();

    @Setter
    private String name;
    @Setter
    private int tries;
    @Setter
    private int wins;

    public static User getInstance() {
        return INSTANCE;
    }

}
