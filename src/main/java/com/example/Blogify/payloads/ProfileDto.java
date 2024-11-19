package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ProfileDto extends Audit {

    @NotEmpty(message = "User name must be mandatory")
    @Max(50)
    private String name;
    private String image;
    @NotEmpty(message = "The address field must be mandatory")
    private String address;

    private String phoneNumber;
    @NotEmpty(message = "The profession field must be mandatory")
    private String profession;
    @NotEmpty (message = "The about field must be mandatory")
    private String about;
}
