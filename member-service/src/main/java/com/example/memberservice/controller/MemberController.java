package com.example.memberservice.controller;

import com.example.memberservice.client.EventRestTemplateClient;
import com.example.memberservice.config.CustomConfig;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.ServletRequest;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final CustomConfig customConfig;
    private final EventRestTemplateClient eventRestTemplateClient;

    public MemberController(CustomConfig customConfig, EventRestTemplateClient eventRestTemplateClient) {
        this.customConfig = customConfig;
        this.eventRestTemplateClient = eventRestTemplateClient;
    }

    // 이벤트 서비스에서 호출할 회원 서비스 내 메소드
    @GetMapping(value = "/name/{nick}")
    public String getYourName(@PathVariable("nick") String nick) {
        return "[MEMBER] Your name is " + customConfig.getYourName() + " / nickname is " + nick;
    }

    /**
     * RestTemplate 를 이용하여 이벤트 서비스의 REST API 호출
     */
    @GetMapping(value = "/gift/{name}")
    public String gift(@PathVariable("name") String name) {
        return "[MEMBER] " + eventRestTemplateClient.gift(name);
    }

    /**
     * ADMIN 권한 소유자만 PUT METHOD API 호출 가능하도록 설정 후 테스트
     */
    @PutMapping("{name}")
    public String member(@PathVariable("name") String name) {
        return "[MEMBER-DELETE] " + name + " is deleted.";
    }

    /**
     * 이벤트 서비스에서 OAuth2 로 호출 테스트
     */
    @GetMapping("userInfo/{name}")
    public String userInfo(@PathVariable("name") String name) {
        return "[MEMBER] " + name;
    }
}