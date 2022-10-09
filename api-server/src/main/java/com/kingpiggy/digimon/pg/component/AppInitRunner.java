package com.kingpiggy.digimon.pg.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * AppInitRunner class.
 * 애플리케이션 구동 후 실행되는 CommandLineRunner
 *
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AppInitRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
    }

}
