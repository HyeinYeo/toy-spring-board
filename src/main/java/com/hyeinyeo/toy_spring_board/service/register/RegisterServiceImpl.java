package com.hyeinyeo.toy_spring_board.service.register;

import com.hyeinyeo.toy_spring_board.domain.User;
import com.hyeinyeo.toy_spring_board.dto.register.SavedUserResponseDto;
import com.hyeinyeo.toy_spring_board.dto.register.UserRegiSuccessDto;
import com.hyeinyeo.toy_spring_board.form.register.UserRegistrationForm;
import com.hyeinyeo.toy_spring_board.mapper.user.RegisterMapper;
import com.hyeinyeo.toy_spring_board.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;

    @Override
    public SavedUserResponseDto register(UserRegistrationForm form) {
        User newUser = userRepository.save(RegisterMapper.toUser(form));
        return RegisterMapper.toSavedUserResponseDto(newUser);
    }

    @Override
    public UserRegiSuccessDto getNewUser(String loginId) {
        User newUser = userRepository.findByLoginId(loginId).orElse(null);

        if (newUser == null) {
            return null;
        }

        return RegisterMapper.toUserRegiSuccessDto(newUser);
    }
}
