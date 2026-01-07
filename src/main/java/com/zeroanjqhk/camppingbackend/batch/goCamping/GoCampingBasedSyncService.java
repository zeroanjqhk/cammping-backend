package com.zeroanjqhk.camppingbackend.batch.goCamping;

import com.zeroanjqhk.camppingbackend.external.gocampping.client.GoCampingClient;
import com.zeroanjqhk.camppingbackend.external.gocampping.request.BasedListRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoCampingBasedSyncService {

    private final GoCampingClient client;
    // private final CampRepository repo;  // DB 붙으면

    public void sync() {
        var req = new BasedListRequest(1, 10);
        String raw = client.fetchBasedListRaw(req);
        System.out.println("[GoCampingBasedSyncJob] raw => " + raw);
        log.info("raw length={}", raw != null ? raw.length() : 0);
    }
}