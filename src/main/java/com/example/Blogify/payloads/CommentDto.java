package com.example.Blogify.payloads;

import com.example.Blogify.entities.Audit;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto extends Audit {

    @NotEmpty(message = "empty comment not allow")
    private String content;
}
