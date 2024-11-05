package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import com.example.Blogify.entities.BlogPost;
import com.example.Blogify.entities.Comment;
import com.example.Blogify.entities.Profile;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDto extends Audit {

    private long id;

    @NotEmpty
    @Email(message = "email field must be mandatory")
    private String email;
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    @Size(min = 8, message = "Password should be 8 character")
    private String password;
    @NotNull(message = "user role must be mandatory")
    private String role;
    private ProfileDto profile;
    private List<BlogPostDto> blogPosts;
    private List<CommentDto> comments;

}
