package com.zeroanjqhk.camppingbackend.external.gocampping.client;

import com.zeroanjqhk.camppingbackend.external.gocampping.GoCampingProperties;
import com.zeroanjqhk.camppingbackend.external.gocampping.request.BasedListRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.net.URI;

@Component
public class GoCampingClient {

    private final RestClient client;
    private final GoCampingProperties props;

    public GoCampingClient(RestClient restClient, GoCampingProperties props) {
        this.props = props;
        this.client = restClient.mutate()
                .baseUrl(props.baseUrl())
                .build();
    }
    public String fetchBasedListRaw(BasedListRequest req) {
        String key = props.serviceKey().trim();

        String fullUrl =
                props.baseUrl()
                        + "/basedList"
                        + "?serviceKey=" + key
                        + "&numOfRows=" + req.numOfRows()
                        + "&pageNo=" + req.pageNo()
                        + "&MobileOS=ETC"
                        + "&MobileApp=REST"
                        + "&_type=json";

        System.out.println("FULL URL => " + fullUrl);

        try {
            return client.get()
                    .uri(URI.create(fullUrl))
                    .retrieve()
                    .body(String.class);
        } catch (HttpClientErrorException e) {
            System.out.println("STATUS=" + e.getStatusCode());
            System.out.println("BODY=" + e.getResponseBodyAsString());
            throw e;
        }
    }
}