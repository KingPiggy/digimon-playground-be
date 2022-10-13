package com.kingpiggy.digimon.pg.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingpiggy.digimon.pg.vo.DigimonVO;
import com.kingpiggy.digimon.pg.web.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.kingpiggy.digimon.pg.ScheduleApplicationConstants.digimonApiUrl;
import static com.kingpiggy.digimon.pg.enumclass.ErrorCode.NOT_RECEIVED_DIGIMON;

/**
 * DigimonBatchService class.
 * <PRE>
 * Describe here.
 * </PRE>
 *
 * <PRE>
 * <B>History:</B>
 * damian.lee, 0.1.0, Created at 2022.10.12
 * </PRE>
 *
 * @author : SEUNGHOON
 * @version : 0.1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DigimonBatchService {

    private final RestTemplate restTemplate;

    private final DigimonService digimonService;

    @Transactional(rollbackFor = Exception.class)
    public void batchDigimon() {

        ResponseEntity<Object[]> response = restTemplate.getForEntity(digimonApiUrl, Object[].class);
        Object[] objects = response.getBody();

        if(objects == null) {
            throw new BusinessException(NOT_RECEIVED_DIGIMON);
        }

        ObjectMapper mapper = new ObjectMapper();
        List<DigimonVO> digimonVOList = Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, DigimonVO.class))
                .collect(Collectors.toList());

        long totalCount = digimonService.saveAllByVO(digimonVOList);

        log.info("[DigimonBatchService] batch done. total count is {}", totalCount);
    }

}
