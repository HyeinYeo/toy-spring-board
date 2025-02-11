package com.hyeinyeo.toy_spring_board.repository;

import com.hyeinyeo.toy_spring_board.domain.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("memory")
public class MemoryUserRepository implements UserRepository{
    private static final Map<Long, User> memberStore = new ConcurrentHashMap<>();
    private static long sequence = 1000L;

    @Override
    public User save(User user) {
        user.setUserId(++sequence);
        memberStore.put(user.getUserId(), user);
        return user;
    }

    @Override
    public User findByUserId(Long id) {
        return memberStore.get(id);
    }

    @Override
    public Optional<User> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(memberStore.values());
    }
}
