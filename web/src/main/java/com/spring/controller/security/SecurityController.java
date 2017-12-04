package com.spring.controller.security;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(path = "/security")
public class SecurityController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public void login() {

    }

}
