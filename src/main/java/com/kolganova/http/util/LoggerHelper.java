package com.kolganova.http.util;

import com.kolganova.http.entity.Acceptance;
import com.kolganova.http.entity.ChallengeAcceptance;
import com.kolganova.http.entity.Phase;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LoggerHelper {

    String servletName;
    Phase phase;
    Acceptance acceptance;
    ChallengeAcceptance challengeAcceptance;
    String parameter;

    public String toStringGet() {
        return phase +
               ", servletMethod=GET" +
               ", servletName=" + servletName;
    }

    public String toStringPost() {
        return phase +
               ", servletMethod=POST" +
               ", servletName=" + servletName;
    }

    public static String createStartTextForGetLog(String servletName) {
        return LoggerHelper.builder()
                .phase(Phase.START)
                .servletName(servletName)
                .build().toStringGet();
    }

    public static String createEndTextForGetLog(String servletName) {
        return LoggerHelper.builder()
                .phase(Phase.END)
                .servletName(servletName)
                .build().toStringGet();
    }

    public static String createTextForProcessMethodLog(ChallengeAcceptance acceptance, String servletName, String parameterChallengeAcceptanceName) {
        return LoggerHelper.builder()
                .phase(Phase.END)
                .servletName(servletName)
                .parameter(parameterChallengeAcceptanceName)
                .challengeAcceptance(acceptance)
                .build().toStringPost();
    }

    public static String createStartTextForPostLog(String servletName) {
        return LoggerHelper.builder()
                .phase(Phase.START)
                .servletName(servletName)
                .build().toStringGet();
    }

    public static String createEndTextForPostLog(String servletName) {
        return LoggerHelper.builder()
                .phase(Phase.END)
                .servletName(servletName)
                .build().toStringGet();
    }

    public static String createTextForProcessMethodLog(Acceptance acceptance, String servletName, String parameterName) {
        return LoggerHelper.builder()
                .phase(Phase.END)
                .servletName(servletName)
                .parameter(parameterName)
                .acceptance(acceptance)
                .build().toStringPost();
    }

}
