package com.hyeinyeo.toy_spring_board.controller;

import com.hyeinyeo.toy_spring_board.constants.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(SessionConst.LOGIN_USER) == null) {
            return "home";
        }

        return "redirect:/articles";
    }
}
