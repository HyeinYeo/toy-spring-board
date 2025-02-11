package com.hyeinyeo.toy_spring_board.repository;

import com.hyeinyeo.toy_spring_board.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    User findByUserId(Long id);
    Optional<User> findByLoginId(String loginId);
    List<User> findAll();
}
