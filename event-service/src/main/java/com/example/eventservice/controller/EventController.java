package com.example.eventservice.controller;

import com.example.eventservice.client.MemberFeignClient;
import com.example.eventservice.client.MemberRestTemplateClient;
import com.example.eventservice.config.CustomConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    private final CustomConfig customConfig;
    private final MemberFeignClient memberFeignClient;
    private final MemberRestTemplateClient memberRestTemplateClient;

    public EventController(CustomConfig customConfig, MemberFeignClient memberFeignClient, MemberRestTemplateClient memberRestTemplateClient) {
        this.customConfig = customConfig;
        this.memberFeignClient = memberFeignClient;
        this.memberRestTemplateClient = memberRestTemplateClient;
    }

    /**
     * 회원 서비스에서 호출할 메서드
     */
    @GetMapping(value = "gift/{name}")
    public String gift(@PathVariable("name") String gift) {
        return "[EVENT] Gift is " + gift;
    }

    @GetMapping(value = "name/{nick}")
    public String getYourName(@PathVariable("nick") String nick) {
        return "[EVENT] Your name is " + customConfig.getYourName() + ", nickname is " + nick;
    }

    /**
     * 회원 서비스 REST API 호출
     */
    @GetMapping(value = "member/{nick}")
    public String getMemberName(@PathVariable("nick") String nick) {
        return memberFeignClient.getYourName(nick);
    }

//    @GetMapping("userInfo/{name}")
//    public String userInfo(@PathVariable("name") String name) {
//        return "[EVENT-MEMBER] " + memberRestTemplateClient.userInfo(name);
//    }

}
