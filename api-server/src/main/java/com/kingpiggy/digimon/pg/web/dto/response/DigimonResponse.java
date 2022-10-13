package com.kingpiggy.digimon.pg.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DigimonResponse class.
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DigimonResponse {

    private Long id;
    private String name;
    private String img;
    private String level;

}
