package com.kingpiggy.digimon.pg.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingpiggy.digimon.pg.vo.DigimonVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.kingpiggy.digimon.pg.ScheduleApplicationConstants.digimonApiUrl;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class DigimonBatchServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("[성공] 디지몬 외부 API 호출")
    void test_batchDigimon() throws Exception {
        // given
        ResponseEntity<Object[]> response = restTemplate.getForEntity(digimonApiUrl, Object[].class);

        // when
        Object[] objects = response.getBody();

        // then
        ObjectMapper mapper = new ObjectMapper();
        List<DigimonVO> result = Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, DigimonVO.class))
                .collect(Collectors.toList());

        System.out.println("# Result");
        System.out.println(result.size());
        assertFalse(result.isEmpty());
    }
    
}