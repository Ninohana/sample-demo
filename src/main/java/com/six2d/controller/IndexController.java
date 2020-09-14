package com.six2d.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index", "/login"})
    public String index(HttpSession session) {
        String key = UUID.randomUUID().toString();
        session.setAttribute("key", key);
        return "login";
    }
}
