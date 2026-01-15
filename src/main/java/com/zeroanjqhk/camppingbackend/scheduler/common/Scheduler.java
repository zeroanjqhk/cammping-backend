package com.zeroanjqhk.camppingbackend.scheduler.common;

import com.zeroanjqhk.camppingbackend.campping.service.GoCampingSyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {

    private final GoCampingSyncService goCampingSyncService;

    // 매 1분마다
    @Scheduled(fixedRate = 60_000)
    public void goCampingBasedSync() {
        log.info("[GoCampingBasedSyncJob] started");
        goCampingSyncService.sync();
        log.info("[GoCampingBasedSyncJob] finished");
    }


}