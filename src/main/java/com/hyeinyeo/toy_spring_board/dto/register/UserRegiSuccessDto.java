package com.hyeinyeo.toy_spring_board.dto.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRegiSuccessDto {
    private String userName;
    private String loginId;
}
