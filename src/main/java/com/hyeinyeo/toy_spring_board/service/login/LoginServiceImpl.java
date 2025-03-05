package com.hyeinyeo.toy_spring_board.service.login;

import com.hyeinyeo.toy_spring_board.domain.User;
import com.hyeinyeo.toy_spring_board.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;

    @Override
    public User login(String loginId, String password) {
        try{
            return userRepository.findByLoginId(loginId)
                    .filter(m -> m.getPassword().equals(password))
                    .orElse(null); // 있는 loginId이지만 패스워드가 맞지 않을 때
        } catch (DataAccessException e){ // 없는 loginId일 때
            log.info("예외 발생: {}", e.getMessage());
            return null;
        }
    }
}
