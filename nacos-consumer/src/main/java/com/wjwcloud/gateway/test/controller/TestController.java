package com.wjwcloud.gateway.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TestController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String hello() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-discovery-server");
        String url = serviceInstance.getUri() + "/hello?name=" + "wjwcloud";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "url : " + url + ", return : " + result;
    }
}
