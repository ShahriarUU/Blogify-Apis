package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import com.example.Blogify.entities.Profile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto extends Audit {

    private long id;
    private String email;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String role;
    private ProfileDto profile;

}
