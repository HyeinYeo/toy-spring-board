package com.hyeinyeo.toy_spring_board.config.interceptor;

import com.hyeinyeo.toy_spring_board.constants.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);

        // 세션 없는 사용자
        if (session == null || session.getAttribute(SessionConst.LOGIN_USER) == null) {
            response.sendRedirect("/login?redirectURL=" + requestURI); // 로그인 페이지로
            return false;
        }

        return true;
    }
}
