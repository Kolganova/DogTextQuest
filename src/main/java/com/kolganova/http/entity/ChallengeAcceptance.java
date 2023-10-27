package com.kolganova.http.entity;

import lombok.Getter;

@Getter
public enum ChallengeAcceptance {
    ACCEPT("Принять"),
    NOT_ACCEPT("Отклонить"),
    LET_DOG_DECIDE("Дать собаке решить");

    private final String russianTranslation;

    ChallengeAcceptance(String russianTranslation) {
        this.russianTranslation = russianTranslation;
    }

}
