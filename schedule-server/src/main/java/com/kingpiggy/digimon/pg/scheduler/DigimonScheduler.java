package com.kingpiggy.digimon.pg.scheduler;

import com.kingpiggy.digimon.pg.service.DigimonBatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * DigimonScheduler class.
 * <PRE>
 * Describe here.
 * </PRE>
 *
 * <PRE>
 * <B>History:</B>
 * damian.lee, 0.1.0, Created at 2022.10.11
 * </PRE>
 *
 * @author : SEUNGHOON
 * @version : 0.1.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DigimonScheduler {

    private final DigimonBatchService digimonBatchService;

    @Scheduled(cron = "0 0 1 * * *")
    public void scheduleBatchDigimon() throws InterruptedException {
        log.info("[DigimonScheduler] schedule start. date is {}", LocalDateTime.now());
        digimonBatchService.batchDigimon();
        log.info("[DigimonScheduler] schedule done.");
    }

}
