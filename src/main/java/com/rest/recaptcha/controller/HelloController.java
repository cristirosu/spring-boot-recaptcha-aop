package com.rest.recaptcha.controller;

import com.rest.recaptcha.aspect.RequiresCaptcha;
import com.rest.recaptcha.dto.HelloDTO;
import com.rest.recaptcha.dto.HelloResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    @RequiresCaptcha
    public HelloResponseDTO hello(@RequestBody HelloDTO helloDTO){
        return new HelloResponseDTO("Hello, " + helloDTO.getName() + "!");
    }

}
