package com.zeroanjqhk.camppingbackend.common.response;

import lombok.Getter;

@Getter
public class CommonResponse<T> {

    private String code;     // 비즈니스 코드 (ex: AUTH_001)
    private String message;
    private T data;

    public CommonResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> success(String code, String message, T data) {
        return new CommonResponse<>(code, message, data);
    }

}
