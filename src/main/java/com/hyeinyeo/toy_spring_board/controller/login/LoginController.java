package com.hyeinyeo.toy_spring_board.controller.login;

import com.hyeinyeo.toy_spring_board.constants.SessionConst;
import com.hyeinyeo.toy_spring_board.domain.User;
import com.hyeinyeo.toy_spring_board.form.login.LoginForm;
import com.hyeinyeo.toy_spring_board.service.login.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form)  {
        return "/login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginForm form,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/articles") String redirectURL,
                        HttpServletRequest request){
        // 입력 검증
        if (bindingResult.hasErrors()) {
            log.info("Login form validation error: {}", bindingResult.getAllErrors());
            return "login/loginForm";
        }

        // 로그인 서비스 로직
        User loginUser = loginService.login(form.getLoginId(), form.getPassword());

        // 로그인 실패
        if (loginUser == null) {
            bindingResult.reject("login.failed", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        // 로그인 성공 및 리다이렉션
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        log.info("Login successful: {}", loginUser);
        log.info("Login session: {}", session.getId());
        return "redirect:" + redirectURL;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
