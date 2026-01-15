package com.zeroanjqhk.camppingbackend.external.gocampping.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BasedListResponse(
        Response response
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Response(
            Header header,
            Body body
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Header(
            String resultCode,
            String resultMsg
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Body(
            Items items
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Items(

            List<Item> item
    ) {
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Item(
            String contentId,
            String facltNm,
            String addr1,
            String doNm,
            String sigunguNm,
            String tel,
            String firstImageUrl,
            String mapX,
            String mapY,
            String induty,
            String manageSttus,
            String lineIntro,
            String intro,
            String createdtime,
            String modifiedtime
    ) {
    }

}
