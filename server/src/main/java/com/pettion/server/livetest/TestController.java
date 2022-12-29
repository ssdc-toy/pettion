package com.pettion.server.livetest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Slf4j
@RequestMapping("api/test")
public class TestController {
    @GetMapping("user1")
    public String getUser1(Principal principal) {
        return principal.getName();
    }


    @GetMapping("user2")
    public String getUser2() {
        log.info("{}",SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
