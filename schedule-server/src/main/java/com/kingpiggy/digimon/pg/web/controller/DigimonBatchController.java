package com.kingpiggy.digimon.pg.web.controller;

import com.kingpiggy.digimon.pg.service.DigimonBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DigimonBatchController class.
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
@RequiredArgsConstructor
@RestController
public class DigimonBatchController {

    private final DigimonBatchService digimonBatchService;

    @GetMapping("/api/batch/digimon")
    public void batchDigimon() {
        digimonBatchService.batchDigimon();
    }

}
