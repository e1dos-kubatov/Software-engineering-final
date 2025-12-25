package com.alaToo.scrs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {


    @Size(max = 50)
    private String email;

    @Size(max = 120)
    private String password;

}
