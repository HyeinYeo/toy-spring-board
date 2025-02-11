package com.hyeinyeo.toy_spring_board.mapper.user;

import com.hyeinyeo.toy_spring_board.domain.User;
import com.hyeinyeo.toy_spring_board.dto.register.SavedUserResponseDto;
import com.hyeinyeo.toy_spring_board.dto.register.UserRegiSuccessDto;
import com.hyeinyeo.toy_spring_board.form.register.UserRegistrationForm;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {
    public static User toUser(UserRegistrationForm form) {
        return User.builder()
                .userName(form.getUserName())
                .loginId(form.getLoginId())
                .password(form.getPassword())
                .build();
    }

    public static SavedUserResponseDto toSavedUserResponseDto(User user) {
        return SavedUserResponseDto.builder()
                .userName(user.getUserName())
                .loginId(user.getLoginId())
                .password(user.getPassword())
                .build();
    }

    public static UserRegiSuccessDto toUserRegiSuccessDto(User user){
        return UserRegiSuccessDto.builder()
                .userName(user.getUserName())
                .loginId(user.getLoginId())
                .build();
    }
}
