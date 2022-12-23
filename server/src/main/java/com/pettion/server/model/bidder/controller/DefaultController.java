package com.pettion.server.model.bidder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class DefaultController {
    @GetMapping
    public String hello() {
        log.info("hello");
        return "hello world!";
    }
}
