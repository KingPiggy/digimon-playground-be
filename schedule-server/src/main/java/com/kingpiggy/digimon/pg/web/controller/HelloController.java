package com.kingpiggy.digimon.pg.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController class.
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
@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello () {
        return "hello";
    }

}
