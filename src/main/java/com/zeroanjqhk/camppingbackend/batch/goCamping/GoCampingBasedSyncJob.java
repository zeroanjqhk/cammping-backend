package com.zeroanjqhk.camppingbackend.batch.goCamping;

import com.zeroanjqhk.camppingbackend.external.gocampping.client.GoCampingClient;
import com.zeroanjqhk.camppingbackend.external.gocampping.request.BasedListRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GoCampingBasedSyncJob {

    private final GoCampingBasedSyncService goCampingBasedSyncService;

    // 🔥 매 1분마다
    @Scheduled(fixedRate = 60_000)
    public void run() {
        log.info("[GoCampingBasedSyncJob] started");
        goCampingBasedSyncService.sync();
        log.info("[GoCampingBasedSyncJob] finished");
    }
}