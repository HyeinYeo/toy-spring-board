package com.hyeinyeo.toy_spring_board.service.register;

import com.hyeinyeo.toy_spring_board.dto.register.SavedUserResponseDto;
import com.hyeinyeo.toy_spring_board.dto.register.UserRegiSuccessDto;
import com.hyeinyeo.toy_spring_board.form.register.UserRegistrationForm;

public interface RegisterService {
    SavedUserResponseDto register(UserRegistrationForm form);
    UserRegiSuccessDto getNewUser(String loginId);
}
