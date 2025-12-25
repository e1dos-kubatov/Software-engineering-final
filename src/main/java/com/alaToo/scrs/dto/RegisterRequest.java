package com.alaToo.scrs.dto;

import com.alaToo.scrs.entity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotNull
    private String username;

    private String password;


    private String firstName;

    @NotNull
    private String lastName;

    @Email
    private String email;

    private String studentId;

    private UserRole role = UserRole.STUDENT;

}
