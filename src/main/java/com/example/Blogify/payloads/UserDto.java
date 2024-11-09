package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto extends Audit{

    @NotEmpty
    @Email(message = "email field must be mandatory")
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    @Size(min = 8, message = "Password should be 8 character")
    private String password;
    private String role;
    private ProfileDto profile;
}
