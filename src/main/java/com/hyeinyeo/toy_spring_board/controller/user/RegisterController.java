package com.hyeinyeo.toy_spring_board.controller.user;

import com.hyeinyeo.toy_spring_board.dto.register.SavedUserResponseDto;
import com.hyeinyeo.toy_spring_board.dto.register.UserRegiSuccessDto;
import com.hyeinyeo.toy_spring_board.form.register.UserRegistrationForm;
import com.hyeinyeo.toy_spring_board.service.register.RegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    // 회원가입 폼
    @GetMapping
    public String registerForm(@ModelAttribute("user") UserRegistrationForm form) {
        return "register/register-form";
    }

    // 회원가입
    @PostMapping
    public String registerUser(@Validated @ModelAttribute("user") UserRegistrationForm form,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "register/register-form";
        }

        SavedUserResponseDto savedUser = registerService.register(form);
        log.info("registered Member: {}", savedUser);

        redirectAttributes.addAttribute("loginId", savedUser.getLoginId());
        return "redirect:/register/success";
    }

    // 회원가입 성공 페이지
    @GetMapping("/success")
    public String registerSuccess(@RequestParam String loginId, Model model) {
        UserRegiSuccessDto newUser = registerService.getNewUser(loginId);
        log.info("new User: {}", newUser);

        if (newUser == null) {
            return "redirect:/"; // 예외처리 향후 추가!
        }

        model.addAttribute("user", newUser);
        return "register/success";
    }

}
