package com.example.eventservice.utils;

import org.springframework.stereotype.Component;

/**
 * 서비스가 쉽게 액세스할 수 있는 HTTP 헤더를 만들어 저장하는 클래스
 * HTTP 요청에서 추출한 값을 보관하는 POJO
 */
@Component
public class CustomContext {
    public static final String CORRELATION_ID = "assu-correlation-id";
    public static final String AUTH_TOKEN     = "Authorization";

    private static final ThreadLocal<String> correlationId = new ThreadLocal<>();
    private static final ThreadLocal<String> authToken = new ThreadLocal<>();

    // 그 외 필요한 항목 넣을 수 있음 (인증 토큰 등...)


    public static String getCorrelationId() {
        return correlationId.get();
    }

    public static void setCorrelationId(String cid) {
        correlationId.set(cid);
    }

    public static String getAuthToken() {
        return authToken.get();
    }

    public static void setAuthToken(String aToken) {
        authToken.set(aToken);
    }
}