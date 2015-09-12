package com.op.service.security.sso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserRestController {
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
