package com.stackroute.gitlabOAuth.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping
    public Map<String, String> getUserName(@AuthenticationPrincipal( expression = "attributes['name']" ) String username ) {
        System.out.println("Name:"+ username);
        return Collections.singletonMap("name", username);
    }

    @GetMapping("/callback")
    public String callback(@RequestParam String code, @RequestParam String state) {
        System.out.println("code: " + code);
        System.out.println("state: " + state);
        return "forward:/index.html";
    }
}
