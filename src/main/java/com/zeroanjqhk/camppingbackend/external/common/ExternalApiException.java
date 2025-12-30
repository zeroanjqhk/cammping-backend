package com.zeroanjqhk.camppingbackend.external.common;

import org.springframework.http.HttpStatus;

public class ExternalApiException extends RuntimeException {
    private final String vendor;       // gocamping, kakao, ...
    private final HttpStatus status;   // 외부 응답 status (없으면 500으로)
    private final String responseBody; // 외부 응답 body 일부(디버깅용)

    public ExternalApiException(String vendor, HttpStatus status, String message, String responseBody, Throwable cause) {
        super(message, cause);
        this.vendor = vendor;
        this.status = status;
        this.responseBody = responseBody;
    }

    public ExternalApiException(String vendor, HttpStatus status, String message, String responseBody) {
        this(vendor, status, message, responseBody, null);
    }

    public String getVendor() { return vendor; }
    public HttpStatus getStatus() { return status; }
    public String getResponseBody() { return responseBody; }
}