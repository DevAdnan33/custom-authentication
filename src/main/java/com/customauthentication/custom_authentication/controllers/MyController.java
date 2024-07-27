package com.customauthentication.custom_authentication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hello-world")
    public String hello() {
        return "Hello World!";
    }
}
