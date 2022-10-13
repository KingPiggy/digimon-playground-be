package com.kingpiggy.digimon.pg.domain.digimon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * DigimonRepository class.
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
@Repository
public interface DigimonRepository extends JpaRepository<DigimonEntity, Long> {

    Optional<DigimonEntity> findByName(String name);

    List<DigimonEntity> findAllByOrderById();
}
