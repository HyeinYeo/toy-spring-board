package com.hyeinyeo.toy_spring_board.service.login;

import com.hyeinyeo.toy_spring_board.domain.User;

public interface LoginService {
    // 패스워드 일치하면 User 객체 반환
    User login(String loginId, String password);
}
