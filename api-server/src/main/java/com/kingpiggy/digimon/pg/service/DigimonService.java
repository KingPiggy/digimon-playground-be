package com.kingpiggy.digimon.pg.service;

import com.kingpiggy.digimon.pg.domain.digimon.DigimonEntity;
import com.kingpiggy.digimon.pg.domain.digimon.DigimonRepository;
import com.kingpiggy.digimon.pg.web.dto.response.DigimonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DigimonService class.
 * <PRE>
 * Describe here.
 * </PRE>
 *
 * <PRE>
 * <B>History:</B>
 * damian.lee, 0.1.0, Created at 2022.10.14
 * </PRE>
 *
 * @author : SEUNGHOON
 * @version : 0.1.0
 */
@Service
@RequiredArgsConstructor
public class DigimonService {

    private final DigimonRepository digimonRepository;

    @Transactional(readOnly = true)
    public List<DigimonResponse> getDigimons() {
        return digimonRepository.findAllByOrderById()
                .stream()
                .map(this::makeDigimonResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<DigimonEntity> getDigimonsPaging(Pageable pageable) {
        return digimonRepository.findAll(pageable);
    }

    private DigimonResponse makeDigimonResponse(DigimonEntity digimonEntity) {
        return DigimonResponse.builder()
                .id(digimonEntity.getId())
                .name(digimonEntity.getName())
                .img(digimonEntity.getImg())
                .level(digimonEntity.getLevel())
                .build();
    }

}
