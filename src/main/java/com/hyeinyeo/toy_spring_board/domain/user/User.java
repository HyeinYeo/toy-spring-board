package com.hyeinyeo.toy_spring_board.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private String loginId;
    private String password;
}
