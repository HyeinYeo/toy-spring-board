package com.hyeinyeo.toy_spring_board.dto.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class SavedUserResponseDto {
    private String userName;
    private String loginId;
    private String password;
}
