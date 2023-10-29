package com.kolganova.http.entity;

import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter
    @Setter
    private static String name;
    @Getter
    @Setter
    private static int tries;
    @Getter
    @Setter
    private static int wins;

}
