package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ProfileDto extends Audit {

    private String name;
    private String image;
    private String address;
    private String phoneNumber;
    private String profession;
    private String about;
}
