package com.kingpiggy.digimon.pg.service;

import com.kingpiggy.digimon.pg.domain.digimon.DigimonEntity;
import com.kingpiggy.digimon.pg.domain.digimon.DigimonRepository;
import com.kingpiggy.digimon.pg.vo.DigimonVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * DigimonService class.
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
@Service
@RequiredArgsConstructor
public class DigimonService {

    private final DigimonRepository digimonRepository;

    @Transactional(rollbackFor = Exception.class)
    public long saveAllByVO(List<DigimonVO> digimonVOList) {

        for(DigimonVO vo : digimonVOList) {
            Optional<DigimonEntity> digimonOptional = digimonRepository.findByName(vo.getName());

            if(digimonOptional.isPresent()) {
                digimonRepository.save(updateDigimonEntityByVO(digimonOptional.get(), vo));
                continue;
            }

            digimonRepository.save(makeDigimonEntity(vo));

        }

        return digimonRepository.count();
    }

    private DigimonEntity makeDigimonEntity(DigimonVO vo) {
        return DigimonEntity.builder()
                .name(vo.getName())
                .img(vo.getImg())
                .level(vo.getLevel())
                .build();
    }

    private DigimonEntity updateDigimonEntityByVO(DigimonEntity digimonEntity, DigimonVO vo) {

        digimonEntity.setImg(vo.getImg());
        digimonEntity.setLevel(vo.getLevel());

        return digimonEntity;
    }

}
