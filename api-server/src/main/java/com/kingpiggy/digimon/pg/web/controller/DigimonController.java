package com.kingpiggy.digimon.pg.web.controller;

import com.kingpiggy.digimon.pg.service.DigimonService;
import com.kingpiggy.digimon.pg.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DigimonController class.
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
@RestController
@RequiredArgsConstructor
public class DigimonController {

    private final DigimonService digimonService;

    @GetMapping("/api/digimons")
    public ApiResponse getDigimons() {
        return ApiResponse.OK(digimonService.getDigimons());
    }

    @GetMapping("/api/digimons/paging")
    public ApiResponse getDigimonsPaging(@RequestParam(defaultValue = "1") Integer pageNo,
                                         @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return ApiResponse.OK(digimonService.getDigimonsPaging(pageable));
    }

}
