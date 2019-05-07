package com.example.demo.modules.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiaweiWu
 */

@Slf4j
@RestController
@RequestMapping("test")
public class TestGatewayController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info(" name = " + name);
        return "hello " + name;
    }
}
