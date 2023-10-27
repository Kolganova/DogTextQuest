package com.kolganova.http.entity;

import lombok.Getter;

@Getter
public enum Acceptance {

    ACCEPT("Принять"),
    NOT_ACCEPT("Отклонить");
    private final String russianTranslation;

    Acceptance(String russianTranslation) {
        this.russianTranslation = russianTranslation;
    }

}
