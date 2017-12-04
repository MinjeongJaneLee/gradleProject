package com.spring.controller;

import com.spring.security.utils.AuthenticationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
@RequestMapping(path = "/")
@Slf4j
public class MainController {

    @RequestMapping(path = "/main", method = RequestMethod.GET)
    public String main(Model model) throws Exception {

        if (Objects.nonNull(AuthenticationUtils.getUserPrincipal())) {
            return "redirect:/contents/manager/contents";
        }
        return "/main/main";
    }
}
