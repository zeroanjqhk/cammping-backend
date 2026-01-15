package com.zeroanjqhk.camppingbackend.external.gocampping;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "external.gocamping")
public record GoCampingProperties(
        String baseUrl,
        String serviceKey,
        String mobileOs,
        String mobileApp,
        String type // json 권장
) {}
