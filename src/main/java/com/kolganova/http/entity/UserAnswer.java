package com.kolganova.http.entity;

import lombok.Getter;
import lombok.Setter;

public class UserAnswer {

    @Getter
    @Setter
    private static ChallengeAcceptance acceptance;
    @Getter
    @Setter
    private static Acceptance dogOnArmsAcceptance;
    @Getter
    @Setter
    private static Acceptance giveFoodAcceptance;
    @Getter
    @Setter
    private static Acceptance petDogAcceptance;
    @Getter
    @Setter
    private static Acceptance keepLookingAcceptance;
}
