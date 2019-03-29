package com.example.demo.modules.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DcController
{
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info(" name = " + name);
        return "hello " + name;
    }
}
