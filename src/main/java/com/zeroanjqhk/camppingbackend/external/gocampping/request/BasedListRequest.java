package com.zeroanjqhk.camppingbackend.external.gocampping.request;

public record BasedListRequest(
        int pageNo,
        int numOfRows
) {
    public static BasedListRequest of(int pageNo, int numOfRows) {
        return new BasedListRequest(pageNo, numOfRows);
    }
}