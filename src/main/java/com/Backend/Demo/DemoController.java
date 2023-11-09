package com.Backend.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {

    @PostMapping(value = "demoUser")
    public String welcome()
    {
        return "Welcome from secure endpoint";
    }

    @PostMapping(value = "demoAdmin")
    public String welcomeAdmin()
    {
        return "Welcome from secure endpoint ADMIN";
    }
}
