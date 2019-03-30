package com.wjwcloud.nacosconfig.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope
public class TestController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Value("${user.name}")
    private String name;

    @GetMapping("/test")
    public String hello() {
//        return name;
        System.err.println("user name :"+name);
        return  "Hello:"+ applicationContext.getEnvironment().getProperty("user.name");
    }
}
