package com.hyeinyeo.toy_spring_board.form.register;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UserRegistrationForm {
    @NotBlank
    @Size(min=2)
    private String userName;

    @NotBlank
    @Size(min=4, max=14)
    private String loginId;

    @NotBlank
    @Size(min=4, max=14)
    private String password;
}
