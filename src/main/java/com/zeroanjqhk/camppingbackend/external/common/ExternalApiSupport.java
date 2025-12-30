package com.zeroanjqhk.camppingbackend.external.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

public class ExternalApiSupport {

    private ExternalApiSupport() {}

    public static ExternalApiException wrap(String vendor, Exception e) {
        // 타임아웃/커넥션 실패
        if (e instanceof ResourceAccessException) {
            return new ExternalApiException(vendor, HttpStatus.GATEWAY_TIMEOUT,
                    "External API timeout/connection error", null, e);
        }

        // 4xx/5xx 응답
        if (e instanceof HttpStatusCodeException se) {
            var status = HttpStatus.valueOf(se.getStatusCode().value());
            // 너무 길어지지 않게 앞부분만 저장(원하면 줄여도 됨)
            String body = se.getResponseBodyAsString();
            if (body != null && body.length() > 2000) body = body.substring(0, 2000);
            return new ExternalApiException(vendor, status, "External API error", body, e);
        }

        return new ExternalApiException(vendor, HttpStatus.BAD_GATEWAY,
                "External API unknown error", null, e);
    }
}