package com.example.Blogify.payloads.ResponseDto;

import com.example.Blogify.entities.Audit;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogWriteByUserDto extends Audit {
    @NotEmpty(message = "blog title must be mandatory")
    private String title;

    private String image;

    @NotEmpty(message = "blog Content must be mandatory")
    private String content;
    private BlogPostCategoryDto category;
    private BlogPostCommentDto comment;

}
